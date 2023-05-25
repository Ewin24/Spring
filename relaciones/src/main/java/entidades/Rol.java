package entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Otros atributos

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

	public Rol(Long id, String nombre, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

    // getters y setters
}
