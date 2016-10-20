package br.com.codecode.cdi.dao;

import java.util.List;

public interface Crud<T> {

	public void create(T entity);
	
	public T update(T entity);
	
	public void deleteById(Long id);

	public T findById(Long id);	

	public List<T> listAll(Integer start, Integer end);
}
