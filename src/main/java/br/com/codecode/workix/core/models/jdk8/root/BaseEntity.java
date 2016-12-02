package br.com.codecode.workix.core.models.jdk8.root;

import java.time.LocalDateTime;

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
 * @since 1.0
 * @version 1.1
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
    protected LocalDateTime createdAt;

    /**
     * Updated at Field
     */
    protected LocalDateTime updatedAt;

}
