package br.com.codecode.workix.core.models.jdk7.root;

import java.util.Calendar;

/**
 * Root Abstract Class MyEntity<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #id}</li>
 * <li>{@link #version}</li>
 * <li>{@link #createdAt}</li>
 * <li>{@link #updatedAt}</li>
 * <li>{@link #uuid}</li>
 * </ul>
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
abstract class BaseEntity {

    /**
     * Id Field
     */
    protected long id;

    /**
     * Version Field
     */
    protected int version;

    /**
     * UUID Field
     */
    protected String uuid;

    /**
     * Created at Field
     */
    protected Calendar createdAt;

    /**
     * Updated at Field
     */
    protected Calendar updatedAt;

}
