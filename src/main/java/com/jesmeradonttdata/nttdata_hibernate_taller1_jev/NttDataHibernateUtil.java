package com.jesmeradonttdata.nttdata_hibernate_taller1_jev;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NttDataHibernateUtil {

	/** Session Factory */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Session Factory Generation.
	 */
	static {

		try {

			// Configuration instance.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Throwable ex) {

			// Instace Error.
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
