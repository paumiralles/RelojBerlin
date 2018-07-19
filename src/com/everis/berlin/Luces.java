package com.everis.berlin;

public enum Luces {

	ROJO("R "), AMARILLO("Y "), APAGADO("O ");

	private String luz;

	Luces(String enuLuz) {
		this.luz = enuLuz;
	}

	public String getLuz() {
		return luz;
	}

}
