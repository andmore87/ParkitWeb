package com.andmore.parkitserver.session;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.List;

import com.andmore.parkitserver.entity.Usuario;

@Path("/webservice")
public class UserService {

	 
	
	   @GET
	    @Path("/json/usuarios/")
	    @Produces("application/json") 
	public List<Usuario> returnData() {

		ArrayList<Usuario> names = new ArrayList<Usuario>();

		Usuario b1 = new Usuario();
		Usuario b2 = new Usuario();
		Usuario b3 = new Usuario();

		b1.setNombre("book nro. 1");
		b1.setId(0);
		b2.setNombre("book nro. 2");
		b2.setId(1);
		b3.setNombre("book nro. 3");
		b3.setId(2);

		names.add(b1);
		names.add(b2);
		names.add(b3);

		return names;
	}

}