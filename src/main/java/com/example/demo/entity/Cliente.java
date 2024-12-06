package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id") // Especifica la columna en la base de datos
    private Long id;

    @Column(name = "cli_nombre") // Especifica la columna en la base de datos
    private String nombre;

    @Column(name = "cli_apellido") // Especifica la columna en la base de datos
    private String apellido;

    @Column(name = "cli_cedula") // Especifica la columna en la base de datos
    private String cedula;

    // Getters y setters
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
