package com.andmore.parkitserver.dao;

import java.util.List;

import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.contexts.Lifecycle;

import com.andmore.parkitserver.daoImpl.DaoGenericoImp;
import com.andmore.parkitserver.entity.Seccion;

public class SeccionDao extends DaoGenericoImp<Seccion, Integer> {

	private static final long serialVersionUID = 1707552797962899419L;


	public List<Seccion> getAllSeccion() {
		getContext();
		String query = "Select s from Seccion s ";
		return listPesq(query);
	}
	
	public Seccion getSeccionById(String id) {
		getContext();
		String query = "Select s from Seccion s where s.id = " + "'"
				+ id + "'";
		return pesq(query);
	}
	
	public List<Seccion> getSeccionByCC(String cc_id) {
		getContext();
		String query = "Select s from Seccion s where s.centro_comercial_id = "+ "'"
				+ cc_id + "'";
		return listPesq(query);
	}
	
	
	public void getContext() {
        boolean createContexts = !Contexts.isEventContextActive()
                      && !Contexts.isApplicationContextActive();
        if (createContexts)
               Lifecycle.beginCall();
  }
}
