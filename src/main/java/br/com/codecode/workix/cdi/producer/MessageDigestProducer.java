package br.com.codecode.workix.cdi.producer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import br.com.codecode.workix.cdi.qualifier.Factory;

/**
 * MessageDigest Producer<br>
 * Use for Encrypt Strings
 * @see Produces
 * @see MessageDigest
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationScoped
public class MessageDigestProducer {
	
	/**
	 * Produce MessageDigest for CDI Injection Points 
	 * @return MessageDigest Instance
	 * @throws NoSuchAlgorithmException if Algorithm is Invalid
	 */
	@Produces
	@Dependent
	@Factory
	@Default
	public MessageDigest getMessageDigest() throws NoSuchAlgorithmException{
		return MessageDigest.getInstance("SHA-256");	
	}
}
