package com.jesmeradonttdata.persistence;

import java.util.List;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Generic DAO.
 * 
 * @author jesmerad
 *
 * @param <T>
 */
public interface CommonDaoI<T> {

	/**
	 * 
	 * Insert a register in the BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);
	
	/**
	 * 
	 * Update a register in the BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);
	
	/**
	 * 
	 * Delete a register in the BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);
	
	/**
	 * 
	 * Search a register by id.
	 * 
	 * @param id
	 * @return
	 */
	public T searchById(final Long id);
	
	/**
	 * 
	 * Search all the registers in the BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();
	
}
