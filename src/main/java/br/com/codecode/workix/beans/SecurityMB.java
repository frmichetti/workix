package br.com.codecode.workix.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Security ManagedBean
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 * @see Serializable
 */
@Named
@SessionScoped
public class SecurityMB extends BaseMB implements Serializable {

   
    private static final long serialVersionUID = 4062470003123871957L;

    @PostConstruct
    @Override
    protected void init() {
    }

}
