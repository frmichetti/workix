package br.com.codecode.workix.cdi.notify;

import br.com.codecode.workix.interfaces.Notificable;

/**
 * Notification Interface for CDI Implementation Uses
 *
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Notificable
 */
public interface Notification {

    void doSendMessage(Notificable to, String title, String body);

}
