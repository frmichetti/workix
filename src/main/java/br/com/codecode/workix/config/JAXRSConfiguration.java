/**
*
* @author Felipe Rodrigues Michetti
* @see http://portfolio-frmichetti.rhcloud.com
* @see http://www.codecode.com.br
* @see mailto:frmichetti@gmail.com
* */
package br.com.codecode.workix.config;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configure Application Path for JaxRs
 * 
 * @see br.com.codecode.workix.rest.android
 * @see br.com.codecode.workix.rest.scaffold
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationPath("services")
public class JAXRSConfiguration extends Application{
    public JAXRSConfiguration() {
        BeanConfig conf = new BeanConfig();
        conf.setTitle("Workix API");
        conf.setDescription("Workix Restfull Api with JAXRS");
        conf.setVersion("1.0.0");
        conf.setHost("localhost:8080");
        conf.setBasePath("/services");
        conf.setSchemes(new String[] { "http" });
        conf.setResourcePackage("br.com.codecode.workix");
        conf.setScan(true);
    }
}
