/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify;

import br.com.codecode.workix.model.jpa.Candidate;
/**
 * Notification Interface for CDI Implementation Uses
 * @author felipe
 * @since 1.0
 * @category FeedBack
 *
 */
public interface Notification {
	
	void doSendMessage(Candidate to,String title, String body);

}
