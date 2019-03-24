package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

/**
 * MyEntity JPA with Inherited Fields and Methods <br>
 * Base abstract Class for Share common Fields <br>
 * All inherited classes MUST contain<br>
 * No Anotation for Compatibility Only with Older Versions
 * <table>
 * <caption> Inherited Fields </caption>
 * <tr>
 * <th>{@link #version}</th>
 * <th>{@link #createdAt}</th>
 * <th>{@link #updatedAt}</th>
 * <th>{@link #uuid}</th>
 * </tr>
 * </table>
 *
 * @author felipe
 * @version 1.1
 * @see Traceable
 * @see Persistable
 * @see Serializable
 * @since 1.0
 */
public abstract class MyEntity implements Traceable, Persistable, Serializable {

    private final static long serialVersionUID = -5791260209364116790L;

    private int version;

    private Calendar createdAt, updatedAt;

    private String uuid;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    protected MyEntity() {
    }

    @Override
    public void generateUUID() {
        this.setUuid(UUID.randomUUID().toString());
    }

    private Calendar getCreatedAt() {
        return createdAt;
    }

    private void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    private Calendar getUpdatedAt() {
        return updatedAt;
    }

    private void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUuid() {
        return uuid;
    }

    private void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private int getVersion() {
        return version;
    }

    private void setVersion(int version) {
        this.version = version;
    }

    @Override
    public void insertTimeStamp() {
        this.setCreatedAt(Calendar.getInstance());
    }

    @Override
    public void prepareToPersist() {
        Traceable.super.prepareToPersist();
    }

    @Override
    public void updateTimeStamp() {
        this.setUpdatedAt(Calendar.getInstance());
    }

}
