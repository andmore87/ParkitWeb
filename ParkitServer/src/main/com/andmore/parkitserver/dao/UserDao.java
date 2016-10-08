package com.andmore.parkitserver.dao;
import java.util.SortedSet;

import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.contexts.Lifecycle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.andmore.parkitserver.entity.Usuario;
import com.andmore.parkitserver.daoImpl.DaoGenericoImp;

import org.jboss.seam.security.Identity;

import com.google.common.collect.Sets;

public class UserDao extends DaoGenericoImp<Usuario, Integer> {

	private static final long serialVersionUID = -8374740396559372677L;
	
	@PersistenceContext 
	private EntityManager entityManager;

	public Usuario getloggedUser(Identity identity) {
		String query = "Select u from Usuario u where u.username like " + "'"
				+ identity.getUsername() + "' and u.password =" +"'"
				+ identity.getPassword()+ "' and u.role = 0";
		return pesq(query);
	}
	
	public Usuario getUserGral(String userName, String password) {
		getContext();
		String query = "Select u from Usuario u where u.username like " + "'"
				+ userName + "' and u.password =" +"'"
				+ password+ "' and u.role = 1 ";
		return pesq(query);
	}

	public SortedSet<Usuario> listUsersByName(String name, int firstResult,
			int maxResult) {
		Query query = null;
		if (name.equals("")) {
			query = getEntityManager().createQuery(
					"SELECT u FROM User u order by u.lastLogin desc");
			return Sets.newTreeSet(query.setFirstResult(firstResult)
					.setMaxResults(maxResult).setFlushMode(FlushModeType.AUTO)
					.getResultList());

		} else {
			query = getEntityManager()
					.createQuery(
							"SELECT u FROM User u WHERE LOWER (u.firstName) like :name OR LOWER (u.lastName) like :name order by u.lastLogin");

			return Sets.newTreeSet(query
					.setParameter("name", "%" + name.toLowerCase() + "%")
					.setFirstResult(firstResult).setMaxResults(maxResult)
					.getResultList());
		}

	}

	public int countUsers(String name) {
		Long result = new Long(0L);
		Query query = getEntityManager()
				.createQuery(
						"select count(u) from User u WHERE LOWER (u.firstName) like :name OR LOWER (u.lastName) like :name order by u.lastLogin");
		result = (Long) query.setParameter("name",
				"%" + name.toLowerCase() + "%").getSingleResult();
		return result.intValue();
	}
	
	public void getContext() {
        boolean createContexts = !Contexts.isEventContextActive()
                      && !Contexts.isApplicationContextActive();
        if (createContexts)
               Lifecycle.beginCall();
  }
	
	public void createNewUser(Usuario usuario){
	    EntityManagerFactory factory = Persistence
	            .createEntityManagerFactory("ParkitServer");
	    entityManager = factory.createEntityManager();
	    try {
			UserTransaction userTrans= (UserTransaction) new InitialContext().lookup("UserTransaction");
			userTrans.begin();
			 // insertUser(usuario);
			  entityManager.joinTransaction(); 
			  entityManager.persist(usuario);
			  userTrans.commit();
			  entityManager.close();
			  factory.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		} 
	     
	  
	  
	   

	    } 
	
  
	}
