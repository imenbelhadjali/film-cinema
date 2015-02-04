package com.stage.pfe.dao;

// Generated 22 janv. 2015 15:22:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.stage.pfe.persistance.Cinema;


import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Cinema.
 * @see com.stage.pfe.dao.Cinema
 * @author Hibernate Tools
 */
public class CinemaHome {

	private static Logger log = Logger.getLogger(CinemaHome.class);

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

	public void persist(Cinema transientInstance) {
		log.debug("persisting Cinema instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cinema instance) {
		log.debug("attaching dirty Cinema instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Cinema instance) {
		log.debug("attaching clean Cinema instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cinema persistentInstance) {
		log.debug("deleting Cinema instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cinema merge(Cinema detachedInstance) {
		log.debug("merging Cinema instance");
		try {
			Cinema result = (Cinema) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cinema findById(java.lang.Integer id) {
		log.debug("getting Cinema instance with id: " + id);
		try {
			Cinema instance = (Cinema) sessionFactory.getCurrentSession()
					.get("com.stage.pfe.dao.Cinema", id);
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

	public List<Cinema> findByExample(Cinema instance) {
		log.debug("finding Cinema instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Cinema> results = (List<Cinema>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.stage.pfe.dao.Cinema")
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
	public List<Cinema> findAll() {//select * from cinema;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Cinema.class);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cinema> findByNom(String n) {//select * from cinema where cond;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Cinema.class).add(Restrictions.eq("nomcinema", n));
		return crit.list();
	}
	

}
