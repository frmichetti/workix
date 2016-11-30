package br.com.codecode.workix.model.base;

import java.sql.Timestamp;

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
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class BaseEntity {

    protected long id;

    protected int version;

    protected String uuid;

    protected Timestamp createdAt;

    protected Timestamp updatedAt;

    /**
     * Public Empty Default Constructor
     */
    public BaseEntity() {
    }
}
