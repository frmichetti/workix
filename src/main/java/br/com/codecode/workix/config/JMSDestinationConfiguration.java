package br.com.codecode.workix.config;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

/**
 * Replace Configuration on JMS HORNETQ inside the Server
 *
 * @see <a href=
 *      "http://www.adam-bien.com/roller/abien/entry/auto_creating_jms_destinations_with">
 *      JMS Destinations JAVA EE 7</a>
 * @author Felipe
 * @since 1.0
 * @version 1.0
 */
@JMSDestinationDefinitions(value = {
        @JMSDestinationDefinition(name = "java:/jms/topics/jobsTopic", destinationName = "jobsTopic",
                interfaceName = "javax.jms.Topic"),
        @JMSDestinationDefinition(name = "java:/jms/topics/usersTopic", destinationName = "usersTopic",
                interfaceName = "javax.jms.Topic"),
        @JMSDestinationDefinition(name = "java:/jms/topics/selectiveProcessesTopic",
                destinationName = "selectiveProcessesTopic", interfaceName = "javax.jms.Topic")})
@Startup
@Singleton
class JMSDestinationConfiguration {
}
