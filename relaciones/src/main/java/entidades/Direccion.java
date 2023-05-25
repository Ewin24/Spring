package entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String ciudad;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

	public Direccion(Long id, String calle, String ciudad, Usuario usuario) {
		super();
		this.id = id;
		this.calle = calle;
		this.ciudad = ciudad;
		this.usuario = usuario;
	}
    
    // getters y setters
}