package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * MyEntity Class for Compatibility
 * <br>Without Annotations<br>
 * Base abstract Class for Share common Fields <br>
 * All inherited classes MUST contain<br>
 * <table>
 * <caption> Inherited Fields </caption>
 * <tr>
 * <th>{@link #version}</th>
 * <th>{@link #createdAt}</th>
 * <th>{@link #updatedAt}</th>
 * <th>{@link #uuid}</th>
 * </tr>
 * </table>.
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.1
 */
abstract class MyEntity implements Serializable {

    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 1L;

    /** The updated at. */
    private Calendar createdAt, updatedAt;

    /** The uuid. */
    private String uuid;

    /** The version. */
    private int version;

    /**
     * Public Default Constructor.
     */
    public MyEntity(){}

    /**
     * Generate UUID.
     */
    protected void generateUUID() {
	this.uuid = UUID.randomUUID().toString();
    }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
	return createdAt;
    }

    /**
     * Gets the updated at.
     *
     * @return the updated at
     */
    public Calendar getUpdatedAt() {
	return updatedAt;
    }

    /**
     * Gets the uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
	return uuid;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
	return version;
    }

    /**
     * Insert time stamp.
     */
    public void insertTimeStamp() {
	this.createdAt = Calendar.getInstance();
    }

    /**
     * Sets the created at.
     *
     * @param createdAt the new created at
     */
    protected void setCreatedAt(Calendar createdAt) {
	this.createdAt = createdAt;
    }

    /**
     * Sets the updated at.
     *
     * @param updatedAt the new updated at
     */
    protected void setUpdatedAt(Calendar updatedAt) {
	this.updatedAt = updatedAt;
    }

    /**
     * Sets the uuid.
     *
     * @param uuid the new uuid
     */
    protected void setUuid(String uuid) {
	this.uuid = uuid;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    protected void setVersion(int version) {
	this.version = version;
    }

    /**
     * Update time stamp.
     */
    protected void updateTimeStamp() {
	this.updatedAt = Calendar.getInstance();
    }

}
