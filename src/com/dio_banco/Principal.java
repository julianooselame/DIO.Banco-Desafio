package com.dio_banco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.dio_banco.Agencia;
import com.dio_banco.Cliente;
import com.dio_banco.Conta;
import com.dio_banco.ContaEspecial;
import com.dio_banco.ContaUniversitaria;

public class Principal {
	

	static ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Conta> contas = new ArrayList<Conta>();

	public static void main(String[] args) {

		int op = 0;

		do {
			op = menu();
			switch (op) {

			case 1: // CADASTRA AGÊNCIA
				novaAgencia(agencias);

				break;

			case 2: // CADASTRA CLIENTE
				novoCliente(clientes);

				break;

			case 3: // CADASTRA CONTA
				novaConta(contas);

				break;

			case 4: // OPERAÇÕES
				operacoes();

				break;

			case 5: // LISTAR CONTAS DE AGÊNCIA
				listaContasAgencia();

				break;

			case 6: // VERIFICA SALDO CLIENTE
				saldoCliente();

				break;

			}

		} while (op != 7);

	}// main

	private static int menu() {
		StringBuilder menu = new StringBuilder();
		menu.append("1 - Cadastrar Agência" + "\n");
		menu.append("2 - Cadastrar Cliente" + "\n");
		menu.append("3 - Cadastrar Conta" + "\n");
		menu.append("4 - Realizar Operações" + "\n");
		menu.append("5 - Listar contas de uma Agência" + "\n");
		menu.append("6 - Verificar Saldo do Cliente" + "\n");
		menu.append("7 - SAIR");
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	private static void novaAgencia(ArrayList<Agencia> agencias) {
		Agencia a = new Agencia();
		a.cadastraAgencia();
		agencias.add(a);
	}

	private static void novoCliente(ArrayList<Cliente> clientes) {
		Cliente c = new Cliente();
		c.cadastrarCliente();
		clientes.add(c);
	}

	private static void novaConta(ArrayList<Conta> contas) {
		String numeroConta;
		Cliente clienteConta;
		Agencia agenciaConta;
		double saldoConta = 0.0;
		double limite = 0.0;

		int digito = -1;
		int digito2 = -1;
		int digito3 = -1;

		numeroConta = JOptionPane.showInputDialog("Digite o número da nova Conta:");

		StringBuilder sb = new StringBuilder();
		sb.append("Digite o código do cliente para o qual quer abrir uma conta:\n\n");
		sb.append("===== LISTA DE CLIENTES ======\n");

		for (int i = 0; i < clientes.size(); i++) {
			sb.append(i + " - " + clientes.get(i).getNome() + "\n");
		}

		StringBuilder sb2 = new StringBuilder();
		sb2.append("Digite o código da agência na qual a conta será aberta:\n\n");
		sb2.append("===== LISTA DE AGÊNCIAS======\n");

		for (int i = 0; i < agencias.size(); i++) {
			sb2.append(
					i + " - " + agencias.get(i).getNumeroAgencia() + " - " + agencias.get(i).getCidadeAgencia() + "\n");
		}

		digito = Integer.parseInt(JOptionPane.showInputDialog(sb.toString()));
		clienteConta = clientes.get(digito);
		digito2 = Integer.parseInt(JOptionPane.showInputDialog(sb2.toString()));
		agenciaConta = agencias.get(digito2);

		StringBuilder miniMenu = new StringBuilder();
		miniMenu.append("Digite o código do Tipo de Conta que deseja cadastrar:\n\n");
		miniMenu.append("1 - CONTA CORRENTE\n");
		miniMenu.append("2 - CONTA ESPECIAL\n");
		miniMenu.append("3 - CONTA UNIVERSITÁRIA");

		digito3 = Integer.parseInt(JOptionPane.showInputDialog(miniMenu).toString());

		if (digito3 == 1) {
			saldoConta = Double.parseDouble(JOptionPane.showInputDialog("Digite o Saldo inicial da conta:"));

			Conta cta = new Conta(numeroConta, clienteConta, agenciaConta, saldoConta);
			contas.add(cta);

			JOptionPane.showMessageDialog(null, "CONTA CORRENTE CADASTRADA");
		}

		if (digito3 == 2) {
			saldoConta = Double.parseDouble(JOptionPane.showInputDialog("Digite o Saldo inicial da conta:"));
			limite = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite da conta:"));

			ContaEspecial cta2 = new ContaEspecial(numeroConta, clienteConta, agenciaConta, saldoConta, limite);

			contas.add(cta2);

			for (int i = 0; i < contas.size(); i++) {

			}
			JOptionPane.showMessageDialog(null, "CONTA ESPECIAL CADASTRADA");

		}

		if (digito3 == 3) {
			saldoConta = Double.parseDouble(JOptionPane.showInputDialog("Digite o Saldo inicial da conta:"));

			if (saldoConta <= 2000) {

				ContaUniversitaria cta3 = new ContaUniversitaria(numeroConta, clienteConta, agenciaConta, saldoConta);

				contas.add(cta3);
				JOptionPane.showMessageDialog(null, "CONTA UNIVERSITÁRIA CADASTRADA");
			} else {
				JOptionPane.showMessageDialog(null,
						"O Saldo da Conta Univeristária não pode ser superior à R$ 2000,00\nDigite outro valor!");
			}
		}

	}

	private static void operacoes() {
		StringBuilder menu = new StringBuilder();
		menu.append("1 - Realizar Saque" + "\n");
		menu.append("2 - Realizar Depósito" + "\n");
		menu.append("3 - Realizar Transferência" + "\n");
		menu.append("4 - VOLTAR");

		int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
		// SAQUE

		if (opcao == 1) {
			int digito = -1;
			double quantia = 0;
			Conta conta = new Conta();
			StringBuilder sb = new StringBuilder();
			sb.append("Selecione a conta para a retirada:\n\n");
			sb.append("===== LISTA DE CONTAS ======\n");

			for (int i = 0; i < contas.size(); i++) {
				sb.append(i + " - Conta: " + contas.get(i).getNumeroConta() + " - Titular: "
						+ contas.get(i).getClienteConta().getNome() + " - Saldo: " + contas.get(i).getSaldoConta()
						+ "\n");
			}
			digito = Integer.parseInt(JOptionPane.showInputDialog(sb.toString()));
			quantia = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantia a ser retirada:"));
			conta = contas.get(digito);
			conta.saque(quantia);
		}

		// DEPOSITO

		if (opcao == 2) {
			int digito = -1;
			double quantia = 0;
			Conta conta = new Conta();
			StringBuilder sb = new StringBuilder();
			sb.append("Selecione a conta para o Depósito:\n\n");
			sb.append("===== LISTA DE CONTAS ======\n");

			for (int i = 0; i < contas.size(); i++) {
				sb.append(i + " - Conta: " + contas.get(i).getNumeroConta() + " - Titular: "
						+ contas.get(i).getClienteConta().getNome() + " - Saldo: " + contas.get(i).getSaldoConta()
						+ "\n");
			}
			digito = Integer.parseInt(JOptionPane.showInputDialog(sb.toString()));
			quantia = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantia a ser retirada:"));
			conta = contas.get(digito);
			conta.deposito(quantia);
		}

		// TRANSFERÊNCIA

		if (opcao == 3) {
			int digito = -1;
			int digito2 = -1;
			double quantia;
			Conta origem = new Conta();
			Conta destino = new Conta();
			StringBuilder sb = new StringBuilder();
			sb.append("Selecione a conta de origem da transferência:\n\n");
			sb.append("===== LISTA DE CONTAS ======\n");

			for (int i = 0; i < contas.size(); i++) {
				sb.append(i + " - Conta: " + contas.get(i).getNumeroConta() + " - Titular: "
						+ contas.get(i).getClienteConta().getNome() + " - Saldo: " + contas.get(i).getSaldoConta()
						+ "\n");
			}
			digito = Integer.parseInt(JOptionPane.showInputDialog(sb.toString()));

			StringBuilder sb2 = new StringBuilder();

			sb2.append("Selecione a conta de destino da transferência:\n\n");
			sb2.append("===== LISTA DE CONTAS ======\n");

			for (int j = 0; j < contas.size(); j++) {
				sb2.append(j + " - Conta: " + contas.get(j).getNumeroConta() + " - Titular: "
						+ contas.get(j).getClienteConta().getNome() + " - Saldo: " + contas.get(j).getSaldoConta()
						+ "\n");
			}
			digito2 = Integer.parseInt(JOptionPane.showInputDialog(sb2.toString()));

			origem = contas.get(digito);
			destino = contas.get(digito2);

			quantia = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantia a ser transferida:"));
			origem.trasnferencia(destino, quantia);

		}
	}

	private static void listaContasAgencia() {
		int digito = -1;

		Agencia agencia = new Agencia();

		StringBuilder sb2 = new StringBuilder();
		sb2.append("Digite o código da agência:\n\n");
		sb2.append("===== LISTA DE AGÊNCIAS======\n");

		for (int i = 0; i < agencias.size(); i++) {
			sb2.append(
					i + " - " + agencias.get(i).getNumeroAgencia() + " - " + agencias.get(i).getCidadeAgencia() + "\n");
		}

		digito = Integer.parseInt(JOptionPane.showInputDialog(sb2.toString()));

		agencia = agencias.get(digito);

		StringBuilder lista = new StringBuilder();
		lista.append("===== LISTA DE CONTAS======\n");

		for (int i = 0; i < contas.size(); i++) {
			if (agencia.getNumeroAgencia().equals(contas.get(i).getAgenciaConta().getNumeroAgencia())) {
				lista.append("Conta: " + contas.get(i).getNumeroConta() + "-Titular: "
						+ contas.get(i).getClienteConta().getNome() + " - Agência: "
						+ contas.get(i).getAgenciaConta().getNumeroAgencia() + " - Cidade: "
						+ contas.get(i).getAgenciaConta().getCidadeAgencia() + " - Saldo: "
						+ contas.get(i).getSaldoConta() + "\n");
			}
		}

		JOptionPane.showMessageDialog(null, lista.toString());
	}

	private static void saldoCliente() {
		int digito = -1;

		Cliente cliente = new Cliente();
		StringBuilder sb = new StringBuilder();
		sb.append("Digite o código do cliente para verificar o Saldo:\n\n");
		sb.append("===== LISTA DE CLIENTES ======\n");

		for (int i = 0; i < clientes.size(); i++) {
			sb.append(i + " - " + clientes.get(i).getNome() + "\n");
		}
		digito = Integer.parseInt(JOptionPane.showInputDialog(sb.toString()));
		cliente = clientes.get(digito);

		for (int j = 0; j < contas.size(); j++) {
			if (cliente.getNome().equals(contas.get(j).getClienteConta().getNome())) {
				JOptionPane.showMessageDialog(null, "CONTA: " + contas.get(j).getNumeroConta() + "\nCliente :"
						+ cliente.getNome() + "\nSaldo: " + contas.get(j).getSaldoConta());

			}
		}

	}


}
