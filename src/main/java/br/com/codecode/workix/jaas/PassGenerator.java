package br.com.codecode.workix.jaas;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.jaas.models.JAASUser;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.security.Base64Encoder;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * This Class Encodes Strings. Use with {@link JAASUser #setPassword(String)}
 *
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class PassGenerator {

    @Inject
    @Factory
    @Default
    private MessageDigest messageDigest;

    public String generate(@NotEmpty String rawPassword) {

        try {

            byte[] hash = messageDigest.digest(rawPassword.getBytes(StandardCharsets.UTF_8.displayName()));

            return Base64Encoder.encode(hash);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}