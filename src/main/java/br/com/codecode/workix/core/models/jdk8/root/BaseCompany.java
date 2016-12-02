package br.com.codecode.workix.core.models.jdk8.root;

/**
 * Root Abstract Class Company<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cnpj}</li>
 * <li>{@link #segment}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BasePerson
 */
public abstract class BaseCompany extends BasePerson {

    /**
     * CNPJ Field
     */
    protected long cnpj;

    /**
     * Segment Field
     */
    protected String segment;
}
