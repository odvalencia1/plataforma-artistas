package com.valencia.ejercicio.models.entities;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_persona")
	private Integer idpersona;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="lugar_nacimiento")
	private String lugarNacimiento;
	
	@Column(name="fecha_nacimiento")
	private Calendar fechaNacimiento;
	
	
	@Column(name="telefonoo")
	private Calendar telefono;
	
	@Column(name="correo_electronico")
	private String correoElectronico;
	
	
	public Persona() {
		super();
	}
	
	public Persona(Integer id ) {
		super();
		this.idpersona=id;
	}
	
	
	public Integer getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	
	@Override
	public String toString() {
		 return this.getApellido() +" "+ this.getNombre();
	 }

	
}
