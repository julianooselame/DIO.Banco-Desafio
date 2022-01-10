package com.dio_banco;

import javax.swing.JOptionPane;

import com.dio_banco.Agencia;
import com.dio_banco.Cliente;
import com.dio_banco.Conta;

public class Conta {
	
	protected String numeroConta;
	protected Cliente clienteConta;
	protected Agencia agenciaConta;
	protected double saldoConta = 0.0;
	

	public Conta() {
		super();
	}

	public Conta(String numeroConta, Cliente clienteConta, Agencia agenciaConta, double saldoConta) {
		super();
		this.numeroConta = numeroConta;
		this.clienteConta = clienteConta;
		this.agenciaConta = agenciaConta;
		this.saldoConta = saldoConta;
	}

	void deposito(double quantia) {
		saldoConta += quantia;
	}
	
	void saque(double quantia) {
		if(quantia > getSaldoConta()) {
			JOptionPane.showMessageDialog(null, "Fundos insuficientes para a operação");
		}else {
		saldoConta -= quantia;
		}
	}
	
	void trasnferencia(Conta destino, double quantia) {
		if(quantia > saldoConta) {
			JOptionPane.showMessageDialog(null, "Fundos insuficientes para a operação");
		}else {
		setSaldoConta(getSaldoConta()-quantia);
		destino.deposito(quantia);
	}
	}
	
	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", clienteConta=" + clienteConta + ", agenciaConta=" + agenciaConta
				+ ", saldoConta=" + saldoConta + "]";
	}

	String retornaDados() {
		StringBuilder sb = new StringBuilder();
		sb.append("CONTA CORRENTE\n");
		sb.append("Número da conta: "+numeroConta+"\n");
		sb.append("Cliente: "+clienteConta.getNome()+"\n");
		sb.append("Agencia: "+agenciaConta.getNumeroAgencia()+" - "+agenciaConta.getCidadeAgencia()+"\n");
		sb.append("Saldo em Conta: "+saldoConta+"\n");
		sb.append("++++++++++++++++++++++++\n");
		
		String retorno = sb.toString();
		
		return retorno;
	}
	
	void cadastrarConta(String numeroConta, Cliente cliente, Agencia agencia, double saldoConta) {
		numeroConta = JOptionPane.showInputDialog("Digite o número da Conta: ");
		Cliente cl = new Cliente();
		Agencia ag = new Agencia();
		cl = cliente;
		ag = agencia;

		
		ag.cadastraAgencia();
		
		
		saldoConta = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo incial da conta:"));
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getClienteConta() {
		return clienteConta;
	}

	public void setClienteConta(Cliente clienteConta) {
		this.clienteConta = clienteConta;
	}

	public Agencia getAgenciaConta() {
		return agenciaConta;
	}

	public void setAgenciaConta(Agencia agenciaConta) {
		this.agenciaConta = agenciaConta;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}

}
