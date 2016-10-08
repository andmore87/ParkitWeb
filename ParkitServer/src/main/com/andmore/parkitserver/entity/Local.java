package com.andmore.parkitserver.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

 

@XmlRootElement
@Entity
public class Local implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8472331566902131560L;
	//seam-gen attributes (you should probably edit these)
	private int id;
	private String numero;
	private String nombre;
	private String descripcion;
	private String foto;
	private String categoria;
	private int centro_comercial_id;
 	private Seccion seccion;
	private String telefono;
	private String url;
	
	
    //add additional entity attributes
	
	//seam-gen attribute getters/setters with annotations (you probably should edit)
		
	@Id @GeneratedValue
	public int getId() {
	     return id;
	}

	public void setId(int id) {
	     this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

 	
	@ManyToOne
	@JoinColumn(name = "seccion")
	@XmlTransient
	public Seccion getSeccion() {
		return seccion;
	}
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
 	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCentro_comercial_id() {
		return centro_comercial_id;
	}

	public void setCentro_comercial_id(int centro_comercial_id) {
		this.centro_comercial_id = centro_comercial_id;
	} 
	
	
	
	
	

	
}
