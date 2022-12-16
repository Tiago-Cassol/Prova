package com.tiago.dao;

import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.tiago.model.Usuario;

@Stateful
public class UsuarioDAO {
	
	@Inject
	private EntityManager em;
	
	public Usuario findById(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> findAllHQL(){
		return em.createQuery("SELECT a FROM Usuario a", Usuario.class).getResultList();
	}
	
	public void save(Usuario u) {
		em.persist(u);
	}
	
}
