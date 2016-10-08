package com.andmore.parkitserver.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.contexts.Lifecycle;
import org.jboss.seam.framework.EntityHome;

import com.andmore.parkitserver.dao.DaoGenerico;

@Transactional
public class DaoGenericoImp<T, ID extends Serializable> extends EntityHome<T>
		implements DaoGenerico<T, ID> {

	private static final long serialVersionUID = -5517139452666879411L;
	private final Class<T> oClass;// object class
	

	public Class<T> getObjectClass() {
		return this.oClass;
	}

	@SuppressWarnings("unchecked")
	public DaoGenericoImp() {
		this.oClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		getContext();
	}

	@Transactional()
	public T atualizar(T object) {
		getEntityManager().joinTransaction();
		getEntityManager().merge(object);
		getEntityManager().flush();

		return object;

	}

	@Transactional()
	public void excluir(T object) {
		getEntityManager().joinTransaction();
		object = getEntityManager().merge(object);
		getEntityManager().remove(object);
		getEntityManager().flush();
	}

	public T pesquisarPorId(ID id) {
		return (T) getEntityManager().find(oClass, id);
	}

	@Transactional
	public T salvar(T object) {
		
		getEntityManager().clear();
		getEntityManager().joinTransaction();
		getEntityManager().persist(object);
		getEntityManager().flush();

		return object;
	}

	@SuppressWarnings("unchecked")
	public List<T> todos() {
		String queryS = "SELECT obj FROM " + oClass.getSimpleName() + " obj";
		Query query = getEntityManager().createQuery(queryS);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> listPesqParam(String query, Map<String, Object> params) {
		Query q = getEntityManager().createQuery(query);
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> listPesqParam(String query, Map<String, Object> params,
			int maximo, int atual) {
		Query q = getEntityManager().createQuery(query).setMaxResults(maximo)
				.setFirstResult(atual);

		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> listPesq(String query) {
		Query q = getEntityManager().createQuery(query);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public T pesq(String query) {
		Query q = getEntityManager().createQuery(query);
		return (T) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public T pesqParam(String query, Map<String, Object> params) {
		Query q = getEntityManager().createQuery(query);
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		try {
			return (T) q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	public void getContext() {
        boolean createContexts = !Contexts.isEventContextActive()
                      && !Contexts.isApplicationContextActive();
        if (createContexts)
               Lifecycle.beginCall();
  }

}
