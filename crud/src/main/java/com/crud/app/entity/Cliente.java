package com.crud.app.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name="clientes")

public class Cliente {
	
	@Id
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email
	private String email;
	@NotNull
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	public Cliente(Long id, @NotEmpty String name, @NotEmpty String apellido, @NotEmpty @Email String email,
			@NotNull Date fecha) {
		super();
		this.id = id;
		this.name = name;
		this.apellido = apellido;
		this.email = email;
		this.fecha = fecha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	

}
