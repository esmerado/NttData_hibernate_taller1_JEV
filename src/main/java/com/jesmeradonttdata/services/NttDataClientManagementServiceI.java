package com.jesmeradonttdata.services;

import com.jesmeradonttdata.persistence.NttDataClient;
import java.util.*;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Client Service Interface.
 * 
 * @author jesmerad
 *
 */
public interface NttDataClientManagementServiceI {

	/**
	 * 
	 * Insert a new client.
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final NttDataClient newClient);
	
	/**
	 * 
	 * Update an existing player.
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final NttDataClient updatedClient);
	
	/**
	 * 
	 * Delete and existing player.
	 * 
	 * @param deletedPlayer
	 */
	public void deletePlayer(final NttDataClient deletedPlayer);
	
	/**
	 * 
	 * @param clientId
	 * @return a client
	 */
	public NttDataClient searchById(final Long clientId);
	
	/**
	 * 
	 * @return List<NttDataClient> of clients.
	 */
	public List<NttDataClient> searchAll();
	
	/**
	 * 
	 * @param name
	 * @param username
	 * @return List<NttDataClient> with a client.
	 */
	public List<NttDataClient> searchByNameAndSurname(final String name, final String username);
	
}
