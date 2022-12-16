package com.tiago.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequencia")
    @SequenceGenerator(name="sequencia", sequenceName="usuario_seq", initialValue = 1, allocationSize = 1)
	private Integer id_usuario;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Pattern(regexp= "[^0-9]*", message="O nome nao pode conter numeros.")
	@Size(min=3, max=30, message="O nome nao pode ter menos que 3 letras e mais que 30 letras.")
	private String nome;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Pattern(regexp="[^a-zA-Z]*", message="O cpf nao pode conter letra.")
	private String cpf;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Size(min = 8, message="A senha deve ter mais que 8 caracteres.")
	private String senha;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Email(message="E-mail deve ser valido.")
	private String email;

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
