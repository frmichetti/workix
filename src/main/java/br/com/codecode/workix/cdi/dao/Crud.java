package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public interface Crud<T extends Serializable> {

	public void create(T entity);
	
	public T update(T entity);
	
	public T saveOrUpdate(T entity);
	
	public void deleteById(Long id);

	public T findById(Long id);	

	public List<T> listAll(Integer start, Integer end);
	
	public BigInteger countRegisters();
}
