/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 * Configure Context Path for JaxRs
 * @see 
 * @author felipe
 *
 */
@ApplicationPath("services")
public class JaxRsConfiguration extends Application{}
