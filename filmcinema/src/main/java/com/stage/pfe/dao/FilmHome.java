package com.stage.pfe.dao;

// Generated 22 janv. 2015 15:22:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.stage.pfe.persistance.Film;







import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Film.
 * @see com.stage.pfe.dao.Film
 * @author Hibernate Tools
 */
public class FilmHome {

	private static Logger log = Logger.getLogger(FilmHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext()
				//	.lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Film transientInstance) {
		log.debug("persisting Personne instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Film instance) {
		log.debug("attaching dirty Film instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	
	public void attachClean(Film instance) {
		log.debug("attaching clean Film instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Film persistentInstance) {
		log.debug("deleting Personne instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Film merge(Film detachedInstance) {
		log.debug("merging Film instance");
		try {
			Film result = (Film) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Film findById(java.lang.Integer id) {
		log.debug("getting Film instance with id: " + id);
		try {
			Film instance = (Film) sessionFactory.getCurrentSession()
					.get("com.stage.pfe.dao.Film", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Film> findByExample(Film instance) {
		log.debug("finding Film instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Film> results = (List<Film>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.stage.pfe.dao.Film")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Film> findAll() {//select * from personne;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Film.class);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Film> findByTitre(String n) {//select * from Film where cond;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Film.class).add(Restrictions.eq("titre", n));
		return crit.list();
	}
	
	public List<String> findFilmsTitle() {
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>) sessionFactory
		.getCurrentSession()
		.createCriteria(Film.class)
		.setProjection(Projections.property("titre"))
		.addOrder(Order.asc("titre"))
		.list();
		return results;
		}

	
}
