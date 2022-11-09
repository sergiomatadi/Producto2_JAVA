package com.CodersTeam.ParaCasa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	@Column(name="DNI")
	private String dni;
	private String usuario;
	private String password;
	private String correo;
	
	@OneToMany(
			mappedBy="usuario",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL
	)
	
	
	private Set<Pedido> pedidos;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String nombre, String dNI, String usuario, String password, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		dni = dNI;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
	}
	
	public Set<Pedido> getPedidos(){
		return pedidos;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dNI) {
		dni = dNI;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}	
}