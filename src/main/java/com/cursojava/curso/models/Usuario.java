package com.cursojava.curso.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "poa_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long idUsuario;
    
    @Getter @Setter @Column(name="cedula")
    private String cedula;

    @Getter @Setter @Column(name="nombre")
    private String nombre;

    @Getter @Setter @Column(name="apellido")
    private String apellido;
    
    @Getter @Setter @Column(name="sexo")
    private String sexo;
    
    @Getter @Setter @Column(name="fechaNacimiento")
    private Date fechaNacimiento;
    
    @Getter @Setter @Column(name="usuario")
    private String usuario;
    
    @Getter @Setter @Column(name="password")
    private String password;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="telefono")
    private String telefono;

    @Getter @Setter @Column(name="estado")
    private String estado;
    
    @Getter @Setter @Column(name="zonal")
    private String zonal;
    
    @Getter @Setter @Column(name="idDireccion")
    private Integer idDireccion;


}
