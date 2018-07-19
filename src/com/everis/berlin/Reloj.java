// Clase Reloj

package com.everis.berlin;

public class Reloj {

	private int hora;
	private int minutos;
	private int segundos;

	public Reloj(int hora, int minutos, int segundos) {
		super();
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

}