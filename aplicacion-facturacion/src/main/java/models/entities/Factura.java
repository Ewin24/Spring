
package models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long folio;
	private String descripcion;
	private String observacion;
	private LocalDate fecha;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	// Constructor, getters y setters

	public Factura(Long folio, String descripcion, String observacion, LocalDate fecha, Cliente cliente) {
		super();
		this.folio = folio;
		this.descripcion = descripcion;
		this.observacion = observacion;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}

