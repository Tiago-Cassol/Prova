package com.tiago.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import com.tiago.dao.UsuarioDAO;
import com.tiago.model.Usuario;

@RequestScoped
@Named
public class UsuarioController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private UsuarioDAO	usuarioDAO;
	
	@Produces
	@Named
	private Usuario novoUsuario;
	
	private List<Usuario> listaUsuarios;
	
	@PostConstruct
	public void inicializarUsuario(){
		novoUsuario = new Usuario();
		listaUsuarios = usuarioDAO.findAllHQL();
	}
	
	public void register() throws Exception{
		try {
        	usuarioDAO.save(novoUsuario);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Registro concluido");
            facesContext.addMessage(null, m);
            inicializarUsuario();
        } catch (Exception e) {
            String errorMessage = getMensagemDeErro(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Errou!!!, nao foi possivel registrar");
            facesContext.addMessage(null, m);
        }
	}
	
	private String getMensagemDeErro(Exception e) {
        String errorMessage = "Falha no registro";
        if (e == null) {
            return errorMessage;
        }
        Throwable t = e;
        while (t != null) {
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        return errorMessage;
	}

	public Usuario getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}

	public List<Usuario> getListaUsuarios() {
		if (listaUsuarios==null) {
			listaUsuarios=usuarioDAO.findAllHQL();
		}
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
	
}
