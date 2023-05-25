package models.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	
	@NotNull
	@Column(name = "creacion_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime creacionAt;

	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Factura> facturas;

	// Constructor, getters y setters

	public Cliente(Long id, String nombre, String apellido, String email, LocalDateTime creacionAt,
			List<Factura> facturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.creacionAt = creacionAt;
		this.facturas = facturas;
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

	public LocalDateTime getCreacionAt() {
		return creacionAt;
	}

	public void setCreacionAt(LocalDateTime creacionAt) {
		this.creacionAt = creacionAt;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public static long getSerialVersionuid() {
		return getSerialVersionuid();
	}
	
	private static final long serialVerionUID = 1L;

}