package br.com.codecode.workix.model.root;

/**
 * Root Abstract Class Company<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cnpj}</li>
 * <li>{@link #segment}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see RootPerson
 */
public abstract class RootCompany extends RootPerson {
	
	protected long cnpj;
	
	protected String segment;
}
