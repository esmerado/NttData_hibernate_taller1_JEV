package com.jesmeradonttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.jesmeradonttdata.persistence.NttDataClient;
import com.jesmeradonttdata.persistence.NttDataClientDaoI;
import com.jesmeradonttdata.persistence.NttDataClientDaoImpl;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Client Service implementation.
 * 
 * @author jesmerad
 *
 */
public class NttDataClientManagementServiceImpl implements NttDataClientManagementServiceI {

	/** DAO: NTTDATA_HEX_CLIENT */
	private NttDataClientDaoImpl clientDao;

	public NttDataClientManagementServiceImpl(final Session session) {
		this.clientDao = new NttDataClientDaoImpl(session);
	}

	@Override
	public void insertNewClient(NttDataClient newClient) {

		// Check if is null and exists
		if (newClient != null && newClient.getClientID() == null) {

			// Insert client.
			clientDao.insert(newClient);
		}

	}

	@Override
	public void updateClient(NttDataClient updatedClient) {

		// Check if is null and exists
		if (updatedClient != null && updatedClient.getClientID() != null) {

			// Updated client.
			clientDao.update(updatedClient);
		}

	}

	@Override
	public void deletePlayer(NttDataClient deletedPlayer) {

		// Check if is null and exists
		if (deletedPlayer != null && deletedPlayer.getClientID() != null) {

			// Remove client.
			clientDao.delete(deletedPlayer);
		}

	}

	@Override
	public NttDataClient searchById(Long clientId) {

		// Result.
		NttDataClient client = null;

		// Check if is null.
		if (clientId != null) {

			// Get the client by id.
			client = clientDao.searchById(clientId);

		}

		return client;
	}

	@Override
	public List<NttDataClient> searchAll() {

		// Result.
		List<NttDataClient> clientList = new ArrayList<NttDataClient>();

		// Get clients.
		clientList = clientDao.searchAll();

		return clientList;
	}

	@Override
	public List<NttDataClient> searchByNameAndSurname(String name, String username) {

		// Result.
		List<NttDataClient> clientList = new ArrayList<NttDataClient>();

		// Get client.
		clientList = clientDao.searchByNameAndSurname(name, username);

		return clientList;
	}

}
