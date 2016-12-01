package br.com.codecode.workix.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.codecode.workix.interfaces.Persistable;

/**
 * JAAS Base Entity Only For Share Common Fields
 * 
 * @author felipe
 * @see Persistable
 * @see Serializable
 */
//@MappedSuperclass
abstract class JAASBase implements Persistable, Serializable {

    private static final long serialVersionUID = 8234434925475474481L;

    private long id;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return id;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }
    
    
    public JAASBase(){}
}