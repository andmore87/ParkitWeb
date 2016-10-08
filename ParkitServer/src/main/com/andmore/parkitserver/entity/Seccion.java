package com.andmore.parkitserver.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@XmlRootElement
@Entity
public class Seccion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9017923844765117708L;
	private int id;
	private String nombre;
	private Centro_Comercial centro_comercial;
	private List<Nodo> nodo;
	private List<Local> local;
	
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centro_comercial")
	@XmlTransient
	public Centro_Comercial getCentro_comercial() {
		return centro_comercial;
	}
	public void setCentro_comercial(Centro_Comercial centro_comercial) {
		this.centro_comercial = centro_comercial;
	}
	//@OneToMany(mappedBy = "seccion",fetch = FetchType.EAGER)
	@OneToMany(mappedBy="seccion", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Nodo> getNodo() {
		return nodo;
	}
	public void setNodo(List<Nodo> nodo) {
		this.nodo = nodo;
	}
	
	//@OneToMany(mappedBy = "seccion",fetch = FetchType.EAGER)
	@OneToMany(mappedBy="seccion", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Local> getLocal() {
		return local;
	}
	public void setLocal(List<Local> local) {
		this.local = local;
	}
	 
 
	
	

}
