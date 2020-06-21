package com.latam.claudio.domian;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message= "Debe ingresar nombre")
	private String nombre;
	
	@NotBlank(message= "Debe ingresar apellido")
	private String apellido;
	
	@NotNull(message= "Fecha de nacimiento es requerido")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaDeNacimiento;
	
	private int edad;
	
	private String cumpleanios;
	
	private String poema;

	public Usuario(int id, String nombre, String apellido, Date fechaDeNacimiento, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.edad = edad;
	}

	public Usuario() {
		super();
	}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getCumpleanios() {
		return cumpleanios;
	}

	public void setCumpleaños(String cumpleanios) {
		this.cumpleanios = cumpleanios;
	}

	public String getPoema() {
		return poema;
	}

	public void setPoema(String poema) {
		this.poema = poema;
	}
	
	
}
