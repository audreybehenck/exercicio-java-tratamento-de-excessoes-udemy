package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Insira os dados da conta: ");
			System.out.print("Número: ");
			int numero = sc.nextInt();
			System.out.print("Titular: ");
			sc.next();
			String titular = sc.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			double limiteSaque = sc.nextDouble();
			
			Conta conta = new Conta(numero, titular, saldo, limiteSaque);
			
			System.out.println("\nInsira o valor para saque: ");
			double quantia = sc.nextDouble();
			
			conta.saque(quantia);
			
			System.out.println(conta.toString());
		}
		catch (DomainException e) {
			System.out.println("Erro no saque: "+ e.getMessage());
		}	
		catch (RuntimeException e) {
		    System.out.println("Erro inesperado.");
		}
		
		sc.close();
	}
}
