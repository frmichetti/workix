/**
*
* @author Felipe Rodrigues Michetti
* @see http://portfolio-frmichetti.rhcloud.com
* @see http://www.codecode.com.br
* @see mailto:frmichetti@gmail.com
* */
package br.com.codecode.workix.config;

import br.com.codecode.workix.jaxrs.converter.JacksonJavaTimeConfiguration;
import br.com.codecode.workix.rest.android.LoginEndpoint;
import br.com.codecode.workix.rest.android.PingEndpoint;
import br.com.codecode.workix.rest.android.SaveOrUpdateEndpoint;
import br.com.codecode.workix.rest.api.*;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configure Application Path for JaxRs
 * 
 * @see br.com.codecode.workix.rest.android
 * @see br.com.codecode.workix.rest.api
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationPath("services")
public class JAXRSConfiguration extends Application{
    public JAXRSConfiguration() {
        BeanConfig conf = new BeanConfig();
        conf.setTitle("Workix Api");
        conf.setDescription("workix api");
        conf.setVersion("1.0.0");
        conf.setHost("localhost:8080");
        conf.setBasePath("/workix/services");
        conf.setSchemes(new String[] { "http" });
        conf.setResourcePackage("br.com.codecode.workix.rest");
        conf.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(JacksonJavaTimeConfiguration.class);

        //ANDROID
        resources.add(LoginEndpoint.class);
        resources.add(PingEndpoint.class);
        resources.add(SaveOrUpdateEndpoint.class);

        //API
        resources.add(AuthorEndpoint.class);
        resources.add(BlogEndpoint.class);
        resources.add(CandidateEndpoint.class);
        resources.add(CommentEndpoint.class);
        resources.add(CompanyEndpoint.class);
        resources.add(JAASRoleEndpoint.class);
        resources.add(JAASUserEndpoint.class);
        resources.add(JobEndpoint.class);
        resources.add(MemberEndpoint.class);
        resources.add(ResumeEndpoint.class);
        resources.add(SelectiveProcessEndpoint.class);
        resources.add(SubscriberEndpoint.class);
        resources.add(TestimonialEndpoint.class);
        resources.add(UserEndpoint.class);

        // classes do swagger...
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        return resources;
    }
}
