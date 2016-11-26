package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Security ManagedBean
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Named
@SessionScoped
public class SecurityMB extends BaseMB{

	private static final long serialVersionUID = 4062470003123871957L;

	@PostConstruct
	@Override
	protected void init(){}

}
