package com.dio_banco;

import javax.swing.JOptionPane;

import com.dio_banco.Agencia;
import com.dio_banco.Cliente;

public class ContaEspecial extends Conta {
	
double limite;
	
	

	public ContaEspecial() {
		super();
	}
	
	public ContaEspecial(String numeroConta, Cliente clienteConta, Agencia agenciaConta, double saldoConta, double limite) {
		super(numeroConta, clienteConta, agenciaConta, saldoConta);
		this.limite = limite;
	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	String retornaDados() {
		StringBuilder sb = new StringBuilder();
		sb.append("CONTA ESPECIAL\n");
		sb.append("Número da conta: "+numeroConta+"\n");
		sb.append("Cliente: "+clienteConta.getNome()+"\n");
		sb.append("Agencia: "+agenciaConta.getNumeroAgencia()+" - "+agenciaConta.getCidadeAgencia()+"\n");
		sb.append("Saldo em Conta: "+saldoConta+"\n");
		sb.append("Limite: "+getLimite()+"\n");
		sb.append("++++++++++++++++++++++++\n");
		
		String retorno = sb.toString();
		
		return retorno;
	}
	@Override
	void saque(double quantia) {
		if(quantia > saldoConta+limite) {
			JOptionPane.showMessageDialog(null, "LIMITE e Saldo insuficientes para a operação");
		}else {
		saldoConta -= quantia;
		}
	}

}
