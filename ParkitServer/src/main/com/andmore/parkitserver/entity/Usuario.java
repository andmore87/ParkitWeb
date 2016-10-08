package com.andmore.parkitserver.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.Length;

@XmlRootElement
@Entity
public class Usuario implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4407387041450748442L;
	//seam-gen attributes (you should probably edit these)
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	private String username;
	private String foto;
	private String placa;
	private int descuentos;
	private int notificaciones;
	private int role;
	
    //add additional entity attributes
	
	//seam-gen attribute getters/setters with annotations (you probably should edit)
	 	
	@Id @GeneratedValue
	public int getId() {
	     return id;
	}

	public void setId(int id) {
	     this.id = id;
	}
	 
	@Length(max=20)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	 
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	  
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	 
	public int getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(int descuentos) {
		this.descuentos = descuentos;
	}
	 
	public int getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(int notificaciones) {
		this.notificaciones = notificaciones;
	}
	  
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	  
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	} 
	
	
	
	
}
