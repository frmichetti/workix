/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.config;

import javax.jms.JMSDestinationDefinition;

/**
 * Replace Configuration on JMS HORNETQ inside the Server 
 * not work on WildFly 9.0.2
 * JAVA EE 7
 * @author Felipe
 *
 */
@JMSDestinationDefinition(
		name="java:/jms/topics/jobsTopic",
		interfaceName="javax.jms.Topic")
public class JMSDestinationConfiguration{}
