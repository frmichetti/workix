package br.com.codecode.workix.jaas.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import br.com.codecode.workix.interfaces.Persistable;

/**
 * JAAS Base Entity Only For Share Common Fields
 * 
 * @author felipe
 * @see Persistable
 * @see Serializable
 */
@MappedSuperclass
abstract class JAASBase implements Persistable, Serializable {

    private static final long serialVersionUID = 8234434925475474481L;

    protected long id; 

    @Override
    public void setId(long id) {
	this.id = id;
    }
    
    
    public JAASBase(){}
}