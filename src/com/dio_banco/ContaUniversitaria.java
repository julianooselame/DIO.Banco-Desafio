package com.dio_banco;

import javax.swing.JOptionPane;

import com.dio_banco.Agencia;
import com.dio_banco.Cliente;
import com.dio_banco.Conta;

public class ContaUniversitaria extends Conta {
	
	double limite = 2000;

	public ContaUniversitaria() {
		super();
	}
	
	public ContaUniversitaria(String numeroConta, Cliente clienteConta, Agencia agenciaConta, double saldoConta) {
		super(numeroConta, clienteConta, agenciaConta, saldoConta);
	}
	
	@Override
	void deposito(double quantia) {
		if (saldoConta <= 2000 && saldoConta+quantia <=2000) {
		saldoConta += quantia;
		}else {
			JOptionPane.showMessageDialog(null, "O saldo da Conta Univerisária não pode ser maior que R$ 2000,00");
		}
	}
	
	@Override
	String retornaDados() {
		StringBuilder sb = new StringBuilder();
		sb.append("CONTA UNIVERSITÁRIA\n");
		sb.append("Número da conta: "+numeroConta+"\n");
		sb.append("Cliente: "+clienteConta.getNome()+"\n");
		sb.append("Agencia: "+agenciaConta.getNumeroAgencia()+" - "+agenciaConta.getCidadeAgencia()+"\n");
		sb.append("Saldo em Conta: "+saldoConta+"\n");
		sb.append("++++++++++++++++++++++++\n");
		
		String retorno = sb.toString();
		
		return retorno;
	}

}
