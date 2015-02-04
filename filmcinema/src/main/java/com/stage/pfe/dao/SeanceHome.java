package com.stage.pfe.dao;

// Generated 22 janv. 2015 15:22:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.stage.pfe.persistance.Film;
import com.stage.pfe.persistance.Seance;






import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Seance.
 * @see com.stage.pfe.dao.Seance
 * @author Hibernate Tools
 */
public class SeanceHome {

	private static Logger log = Logger.getLogger(SeanceHome.class);

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

	public void persist(Seance transientInstance) {
		log.debug("persisting Seance instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Seance instance) {
		log.debug("attaching dirty Seance instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Seance instance) {
		log.debug("attaching clean Seance instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Seance persistentInstance) {
		log.debug("deleting Seance instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Seance merge(Seance detachedInstance) {
		log.debug("merging Seance instance");
		try {
			Seance result = (Seance) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Seance findById(java.lang.Integer id) {
		log.debug("getting Seance instance with id: " + id);
		try {
			Seance instance = (Seance) sessionFactory.getCurrentSession()
					.get("com.stage.pfe.dao.Seance", id);
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

	public List<Seance> findByExample(Seance instance) {
		log.debug("finding Seance instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Seance> results = (List<Seance>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.stage.pfe.dao.Seance")
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
	public List<Seance> findAll() {//select * from Seance;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Seance.class);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Seance> findByNum(String n) {//select * from Seance where cond;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Seance.class).add(Restrictions.eq("numseance", n));
		return crit.list();
	}
	
	public List<Seance> findAllWithJoin(){
		try {
		@SuppressWarnings("unchecked")
		List<Seance> results = (List<Seance>) sessionFactory
		.getCurrentSession()
		.createCriteria(Seance.class)
		.setFetchMode("salle", FetchMode.JOIN)
		.setFetchMode("film", FetchMode.JOIN)
		.list();
		return results;
		} catch (RuntimeException re) {
		throw re; }
		}


	public List<Seance> findSeancesFilter(Integer numseance) {
		
		
		@SuppressWarnings("unchecked")
		List<Seance> results = (List<Seance>) sessionFactory.getCurrentSession()
		.createCriteria(Seance.class)
		.add(Restrictions.lt("numseance", numseance)).list();
		
		return results;
}

}



