package br.com.codecode.workix.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import br.com.codecode.workix.model.interfaces.BaseEntity;
/**
 * Crud Interface for CDI Implementation Uses
 * @author felipe
 * @since 1.0
 * @category Persistence
 * @param <T>
 */
public interface Crud<T extends BaseEntity> {

	public void save(T entity);
	
	public T update(T entity);
	
	public T saveOrUpdate(T entity);
	
	public void deleteById(long id);

	public T findById(long id);	
	
	public T findByUuid(String uuid);

	public List<T> listAll(int start, int end);
	
	public BigInteger countRegisters();
}
