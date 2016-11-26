/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.jboss.security.Base64Encoder;

import br.com.codecode.workix.cdi.qualifier.Factory;

/**
 * This Class Encodes Strings
 * Use with {@link JAASUser #setPassword(String)} 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class PassGenerator {
	
	@Inject @Factory @Default
	private MessageDigest messageDigest;
    
	public String generate(String rawPassword){		
		
		try {
			
			byte[] hash = messageDigest
					.digest(rawPassword.getBytes(StandardCharsets.UTF_8.displayName()));
			
			return Base64Encoder.encode(hash);
			
		} catch (IOException e) {
			
			throw new RuntimeException(e);
		} 
	}
}