package entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

	public Orden(Long id, String nombre, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
	}
    
    // getters y setters
}
