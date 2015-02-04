package com.stage.pfe.dao;

// Generated 22 janv. 2015 15:22:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.stage.pfe.persistance.Salle;


import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Salle.
 * @see com.stage.pfe.dao.Salle
 * @author Hibernate Tools
 */
public class SalleHome {

	private static Logger log = Logger.getLogger(SalleHome.class);

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

	public void persist(Salle transientInstance) {
		log.debug("persisting Salle instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Salle instance) {
		log.debug("attaching dirty Salle instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salle instance) {
		log.debug("attaching clean Salle instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Salle persistentInstance) {
		log.debug("deleting Salle instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salle merge(Salle detachedInstance) {
		log.debug("merging Salle instance");
		try {
			Salle result = (Salle) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Salle findById(java.lang.Integer id) {
		log.debug("getting Salle instance with id: " + id);
		try {
			Salle instance = (Salle) sessionFactory.getCurrentSession()
					.get("com.stage.pfe.dao.Salle", id);
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

	public List<Salle> findByExample(Salle instance) {
		log.debug("finding Salle instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Salle> results = (List<Salle>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.stage.pfe.dao.Salle")
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
	public List<Salle> findAll() {//select * from Salle;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Salle.class);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Salle> findByNom(String n) {//select * from Salle where cond;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Salle.class).add(Restrictions.eq("nomSalle", n));
		return crit.list();
	}
	

}
