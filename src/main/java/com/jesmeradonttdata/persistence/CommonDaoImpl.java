package com.jesmeradonttdata.persistence;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Common DAO Implement.
 * 
 * @author jesmerad
 *
 * @param <T>
 */
public class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Class Type */
	private Class<T> entityClass;

	/** BBDD Connection sesion */
	private Session session;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(T paramT) {

		// Session verify.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insertion.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void update(T paramT) {

		// Session verify.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insertion.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();;

	}

	@Override
	public void delete(T paramT) {

		// Session verify.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insertion.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public T searchById(Long id) {

		// Session verify.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Search by PK.
		T result = session.get(this.entityClass, id);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		
		// Session verify..
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Search All.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
