package entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    
    @OneToOne(mappedBy = "usuario")
    private Direccion direccion;

	public Usuario(Long id, String nombre, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

    // getters y setters
    
}

