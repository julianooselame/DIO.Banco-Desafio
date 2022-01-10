package com.dio_banco;

import javax.swing.JOptionPane;

	public class Agencia {
		
	private String numeroAgencia;
	private String cidadeAgencia;
	private String bairroAgencia;
	
	
	@Override
	public String toString() { //UTILIZAR GETS
		return "Agencia [numeroAgencia=" + numeroAgencia + ", cidadeAgencia=" + cidadeAgencia + ", bairroAgencia="
				+ bairroAgencia + "]";
	}
	String retornaDados() { //UTILIZAR GETS
		StringBuilder sb = new StringBuilder();
		sb.append("N�mero da Ag�ncia: "+numeroAgencia+"\n");
		sb.append("Cidade: "+cidadeAgencia+"\n");
		sb.append("Bairro: "+bairroAgencia+"\n");
		sb.append("++++++++++++++++++++++++\n");
		
		String retorno = sb.toString();
		
		return retorno;

}
	void cadastraAgencia() { //UTILIZAR SETS
		numeroAgencia = JOptionPane.showInputDialog("N�mero da Ag�ncia:");
		cidadeAgencia = JOptionPane.showInputDialog("Cidade da Ag�ncia:");
		bairroAgencia = JOptionPane.showInputDialog("Bairro da Ag�ncia:");
	}
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getCidadeAgencia() {
		return cidadeAgencia;
	}
	public void setCidadeAgencia(String cidadeAgencia) {
		this.cidadeAgencia = cidadeAgencia;
	}
	public String getBairroAgencia() {
		return bairroAgencia;
	}
	public void setBairroAgencia(String bairroAgencia) {
		this.bairroAgencia = bairroAgencia;
	}
}
