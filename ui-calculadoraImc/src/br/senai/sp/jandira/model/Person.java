package br.senai.sp.jandira.model;

public class Person {

	private double bmi;
	private String status;

	public void calculateBmi(double weight,  double height) {
		bmi = weight / (height * height);
	}

	public double getBmi() {
		return bmi;
	}
	
	public void setStatus () {
		if (bmi <= 18.5) {
			status = "Abaixo do peso";
		} else if (bmi >= 18.6 && bmi < 24.9) {
			status = "Peso ideal";
		} else if (bmi >= 25.0 && bmi < 29.9) {
			status = "Acima do peso";
		} else if (bmi >= 30.0 && bmi < 34.9) {
			status = "Obesidade";
		} else if (bmi >= 35.0 && bmi < 39.9) {
			status = "Obesidade severa";
		} else {
			status = "Obesidade mórbida";
		}
	}
	
	public String getStatus() {
		return status;
	}

}
