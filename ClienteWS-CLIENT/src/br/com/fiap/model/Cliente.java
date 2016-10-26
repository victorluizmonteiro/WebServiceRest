package br.com.fiap.model;

import java.io.Serializable;
import java.util.Calendar;

public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 7729584362009575133L;
	private int id;
	private String nome;
	private String telefone;
	private String logradouro;
	private Calendar dataNascimento;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	

	public Cliente(int id, String nome, String telefone, String logradouro, Calendar dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.dataNascimento = dataNascimento;
	}

	public Cliente() {
		super();
	}

}
