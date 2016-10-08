package com.andmore.parkitserver.dao;

import java.util.List;

import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.contexts.Lifecycle;

import com.andmore.parkitserver.daoImpl.DaoGenericoImp;
import com.andmore.parkitserver.entity.Centro_Comercial;

public class CentroComercialDao extends DaoGenericoImp<Centro_Comercial, Integer> {

	private static final long serialVersionUID = 1707552797962899419L;


	public List<Centro_Comercial> getAllCC() {
		getContext();
		String query = "Select c from Centro_Comercial c ";
		return listPesq(query);
	}
	
	
	public void getContext() {
        boolean createContexts = !Contexts.isEventContextActive()
                      && !Contexts.isApplicationContextActive();
        if (createContexts)
               Lifecycle.beginCall();
  }
}
