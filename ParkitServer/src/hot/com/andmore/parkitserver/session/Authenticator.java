package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Identity;

import com.andmore.parkitserver.dao.UserDao;
import com.andmore.parkitserver.entity.Usuario;

@Name("authenticator")
public class Authenticator {
	@Logger
	Log log;

	@In
	Identity identity;
	UserDao userDao;

	public boolean authenticate() {
		userDao = new UserDao();
		//centroComercialDao = new CentroComercialDao();
		boolean response;
		log.info("authenticating #0", identity.getUsername());
		Usuario loggedUser = userDao.getloggedUser(identity);
		if (loggedUser != null) {
			identity.addRole("admin");
			identity.setUsername(loggedUser.getNombre());
			response = true;
		} else {
			response = false;
		}

//		List<Centro_Comercial> listcentroComer = centroComercialDao.getAllCC();
		return response;
	}
}
