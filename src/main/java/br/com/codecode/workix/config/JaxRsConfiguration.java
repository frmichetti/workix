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
 * Configure Application Path for JaxRs
 * @see br.com.codecode.workix.rest.android
 * @see br.com.codecode.workix.rest.scaffold
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationPath("services")
public class JaxRsConfiguration extends Application{}
