package com.jesmeradonttdata.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * table DAO NTTDATA_HEX_CLIENT
 * 
 * @author jesmerad
 *
 */
public class NttDataClientDaoImpl extends CommonDaoImpl<NttDataClient> implements NttDataClientDaoI {

	/** BBDD Connection sesion */
	private Session session;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param session
	 */
	public NttDataClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataClient> searchByNameAndSurname(String name, String first_surname) {

		// Open Session verification.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Find client by name.
		final List<NttDataClient> clientsList = session.createQuery("FROM NttDataClient WHERE name='" + name + "' AND firstSurname='" + first_surname + "'").list();

		return clientsList;
	}

}
