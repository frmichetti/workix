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

    
    protected long getId() {
        return id;
    }

    
    protected int getVersion() {
        return version;
    }

    
    protected String getUuid() {
        return uuid;
    }

    
    protected Calendar getCreatedAt() {
        return createdAt;
    }

    
    protected Calendar getUpdatedAt() {
        return updatedAt;
    }

    
    protected void setId(long id) {
        this.id = id;
    }

    
    protected void setVersion(int version) {
        this.version = version;
    }

    
    protected void setUuid(String uuid) {
        this.uuid = uuid;
    }

    
    protected void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    
    protected void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    

}
