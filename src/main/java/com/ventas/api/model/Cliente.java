package com.ventas.api.model;


import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(nullable = false, length=70)
    private String nombres;
    @Column(nullable = false, length = 150)
    private String apellidos;
    @Column(nullable = true, length = 150)
    private String direccion;
    @Column(nullable = true, length = 10)
    private String telefono;
    @Column(nullable = false, length = 150)
    private String email;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombres, String apellidos) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
