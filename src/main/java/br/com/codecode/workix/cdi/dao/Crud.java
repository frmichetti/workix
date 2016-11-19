package br.com.codecode.workix.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;
/**
 * Crud Interface for CDI Implementation Uses
 * @author felipe
 * @since 1.0
 * @category Persistence
 * @param <T>
 */
public interface Crud<T extends BasicEntity> {

	public void save(T entity);
	
	public T update(T entity);
	
	public T saveOrUpdate(T entity);
	
	public void deleteById(Long id);

	public T findById(Long id);	
	
	public T findByUuid(String uuid);

	public List<T> listAll(Integer start, Integer end);
	
	public BigInteger countRegisters();
}
