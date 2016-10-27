package br.com.codecode.workix.cdi.dao;

import java.math.BigInteger;
import java.util.List;

public interface Crud<T> {

	public void create(T entity);
	
	public T update(T entity);
	
	public void deleteById(Long id);

	public T findById(Long id);	

	public List<T> listAll(Integer start, Integer end);
	
	public BigInteger countRegisters();
}
