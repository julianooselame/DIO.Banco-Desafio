package com.dio_banco;

import javax.swing.JOptionPane;

public class Cliente {
	
	private String nome;
	private String nascimento;
	private char sexo;
	
	
	public Cliente() {
		
	}

	public Cliente(String nome, String nascimento, char sexo) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
	}

	void cadastrarCliente() {
		nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		nascimento = JOptionPane.showInputDialog("Digite a data de nascimento: ");
		sexo = JOptionPane.showInputDialog("Digite o sexo da pessoa \nMasculino \nFeminino: ").toUpperCase().charAt(0);
	}
	
	
	
	@Override
	public String toString() {//TROCAR POR retorna dados
		return "Cliente [nome=" + nome + ", nascimento=" + nascimento + ", sexo=" + sexo + "]";
	}

	String retornaDados() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: "+nome+"\n");
		sb.append("Nascimento: "+nascimento+"\n");
		sb.append("Sexo: "+sexo+"\n");
		sb.append("++++++++++++++++++++++++\n");
		
		String retorno = sb.toString();
		
		return retorno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
