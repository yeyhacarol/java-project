package br.senai.sp.jandira.model;

public class Viagem {

	private double quilometragemTotal, autonomiaCarro, precoCombustivel;
	private double custoTotal;

	public double getQuilometragemTotal() {
		return quilometragemTotal;
	}

	public void setQuilometragemTotal(String quilometragemTotal) {
		this.quilometragemTotal = Double.parseDouble(quilometragemTotal);
	}

	public double getAutonomiaCarro() {
		return autonomiaCarro;
	}

	public void setAutonomiaCarro(String autonomiaCarro) {
		this.autonomiaCarro = Double.parseDouble(autonomiaCarro);
	}

	public double getPrecoCombustivel() {
		return precoCombustivel;
	}

	public void setPrecoCombustivel(String precoCombustivel) {
		this.precoCombustivel = Double.parseDouble(precoCombustivel);
	}

	public void calcularCusto() {
		this.custoTotal = quilometragemTotal / autonomiaCarro * precoCombustivel;
	}

	public double getCusto() {
		return custoTotal;
	}

}
