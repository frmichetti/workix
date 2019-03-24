package br.com.codecode.workix.cdi.producers;

import br.com.codecode.workix.cdi.qualifiers.Factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MessageDigest Producer<br>
 * Use for Encrypt Strings
 *
 * @author felipe
 * @version 1.0
 * @see Produces
 * @see MessageDigest
 * @since 1.0
 */
@ApplicationScoped
public class MessageDigestProducer {

    /**
     * Produce MessageDigest for CDI Injection Points
     *
     * @return MessageDigest Instance
     * @throws NoSuchAlgorithmException if Algorithm is Invalid
     */
    @Produces
    @Dependent
    @Factory
    @Default
    public MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256");
    }
}
