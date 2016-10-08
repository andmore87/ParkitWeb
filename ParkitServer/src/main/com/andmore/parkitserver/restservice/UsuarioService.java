package com.andmore.parkitserver.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.andmore.parkitserver.dao.CentroComercialDao;
import com.andmore.parkitserver.dao.UserDao;
import com.andmore.parkitserver.entity.Centro_Comercial;
import com.andmore.parkitserver.entity.Usuario;

@Path("/userservice")
public class UsuarioService {
	
	 UserDao userDao;
	 private static String TKN_SUCCESS = "success";
	 private static String TKN_REGISTER_USER ="regisuser";
	 private static String TKN_ERROR = "error";
	 //http://localhost:9090/ParkitServer/rest/userservice/nando/654321
	 //http://localhost:9090/ParkitServer/rest/userservice/user?username=nando&password=654321
	 //http://192.168.1.2:8088/ParkitServer/rest/userservice/getuser
	
	@GET
	@Path("/getuser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Centro_Comercial> getUsuario(@QueryParam("username") String userName, @QueryParam("password") String password){
		List<Centro_Comercial> ccResponse = new ArrayList();
		Centro_Comercial ccErro = new Centro_Comercial();
		userDao = new UserDao();
		CentroComercialDao ccDao = new CentroComercialDao();
		try {
			Usuario userGral = userDao.getUserGral(userName, password);
			System.out.print("logged user: "+userGral.getUsername());
			ccResponse =ccDao.getAllCC();	
		} catch (Exception e) {
			ccErro.setNombre(TKN_ERROR);
			ccResponse.add(ccErro);
			ccResponse.add(ccErro);
			System.out.print("error consultando user: "+e.getMessage());
		}
		return ccResponse;
		}
	
	
	@GET
	@Path("/saveuser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Centro_Comercial> saveUsuario(@QueryParam("name") String name, @QueryParam("lastName") String lastName, @QueryParam("email") String email,@QueryParam("password") String password,@QueryParam("username") String username,@QueryParam("placa") String plate, @QueryParam("descuentos") String descuentos,@QueryParam("notificaciones") String notificaciones,@QueryParam("role") String role){
		List<Centro_Comercial> ccResponse = new ArrayList();
		Centro_Comercial ccErro = new Centro_Comercial();
		userDao = new UserDao();
		 CentroComercialDao ccDao = new CentroComercialDao();
		Usuario userGral = null;
		try {
			userGral = userDao.getUserGral(username, password);
			ccErro.setNombre(TKN_ERROR);
			ccResponse.add(ccErro);
			System.out.println("user already exists");
				
		} catch (Exception e) {
				System.out.println("user ready for insert");
				userGral = new Usuario();
				userGral.setNombre(name);
				userGral.setApellido(lastName);
				userGral.setCorreo(email);
				userGral.setPassword(password);
				userGral.setUsername(username);
				userGral.setPlaca(plate);
				userGral.setDescuentos(Integer.parseInt(descuentos));
				userGral.setNotificaciones(Integer.parseInt(notificaciones));
				userGral.setRole(Integer.parseInt(role));
				
				try {
					userDao.createNewUser(userGral);
					ccResponse =ccDao.getAllCC();	
				} catch (Exception e2) {
					ccErro.setNombre(TKN_ERROR);
					ccResponse.add(ccErro);
				}
			
		}
		return ccResponse;
		}
	
	  @GET  
	     @Path("/hello")  
	     @Produces("text/plain")  
	     public String hello(){  
	         return "Hello World!!! dineshonjava";      
	     }  
	       
	     @GET  
	     @Path("/message/{message}")  
	     @Produces("text/plain")  
	     public String showMsg(@PathParam("message") String message){  
	         return message;      
	     }  

}
