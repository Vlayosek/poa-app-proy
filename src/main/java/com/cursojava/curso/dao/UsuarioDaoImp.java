package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("deprecation")
	@Override
    public Usuario obtenerUsuarioXCredenciales(Usuario reqUsuario) {
        //String query = "FROM Usuario WHERE email = :email AND password = :password";
        String query = "FROM Usuario WHERE email = :email";
        @SuppressWarnings("unchecked")
		List<Usuario> lista = em.createQuery(query)
                .setParameter("usuario", reqUsuario.getUsuario())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed, reqUsuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }
}
