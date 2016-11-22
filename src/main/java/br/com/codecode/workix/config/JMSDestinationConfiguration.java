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
 * @see <a href="http://www.adam-bien.com/roller/abien/entry/auto_creating_jms_destinations_with"> JMS Destinations </a>
 * 
 * 
 * JAVA EE 7
 * @author Felipe
 *
 */
public class JMSDestinationConfiguration{
	
	@JMSDestinationDefinition(
			name="java:/jms/topics/jobsTopic",
			destinationName = "jobsTopic",
			interfaceName="javax.jms.Topic")
	public class JobsTopicConfig{}
	
	@JMSDestinationDefinition(
			name="java:/jms/topics/usersTopic",
			destinationName = "usersTopic", 
			interfaceName="javax.jms.Topic")
	public class UsersTopicConfig{}	
	@JMSDestinationDefinition(
			name="java:/jms/topics/selectiveProcessesTopic",
			destinationName = "selectiveProcessesTopic",
			interfaceName="javax.jms.Topic")
	public class SelectiveProcessesConfig{}
	
}
