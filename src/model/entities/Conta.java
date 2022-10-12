package model.entities;

import model.exceptions.DomainException;

public class Conta {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	
	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}


	public Integer getNumero() {
		return numero;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public Double getSaldo() {
		return saldo;
	}


	public Double getLimiteSaque() {
		return limiteSaque;
	}
	
	public void deposito(double quantia) {
		saldo += quantia;
	}
	
	public void saque(double quantia) {
		if (saldo < quantia) {
			throw new DomainException ("Não há saldo suficiente.");
		}
		if (limiteSaque < quantia) {
			throw new DomainException ("Seu limite de saque é menor do que a quantia que você deseja sacar.");
		}
		if (saldo > quantia) {
			saldo -= quantia;
		} 
	}
	
	@Override
	public String toString() {
		return "Novo saldo: "
				+ String.format("%.2f", saldo);
	}
}
