package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    Usuario obtenerUsuarioXCredenciales(Usuario reqUsuario);
}
