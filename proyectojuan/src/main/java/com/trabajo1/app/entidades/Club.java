package com.trabajo1.app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugador> jugadores;

    @NotEmpty
    private String name;

    public Club() {
    }

    public Club(@NotEmpty String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
