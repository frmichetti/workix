package br.com.codecode.workix.jpa.models;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.cdi.qualifiers.Persist;

/**
 * Comment JPA with Inherited Fields and Methods
 * 
 * @see MyEntity
 * @author felipe
 * 
 * @since 1.0
 * @version 1.0
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Comment extends MyEntity {
    
    private long id;

    /**
     * 
     */
    private static final long serialVersionUID = 7358996279677908814L;

    @Override
    public long getId() {	
	return id;
    }

    @Override
    public void setId(long id) {
	this.id = id;	
    }

}
