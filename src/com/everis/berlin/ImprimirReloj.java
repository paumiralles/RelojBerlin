//Esta clase imprime por pantalla la represetnación de las luces que estan encendidas y las que están apagadas.

package com.everis.berlin;

public class ImprimirReloj {

	final static String SEPARADOR = ":";
	final static int LONGITUD_FILAS_1_2_4 = 4;
	final static int LONGITUD_FILA_3 = 11;
	final static int VALOR_LUZ_ENCENDIDA = 5;
	final static int DIVISIONES_FILA_3 = 3;
	

	public StringBuilder calcularLucesBerlin(Reloj reloj) {
		
		String fila0 = "";
		StringBuilder respuesta = new StringBuilder();

		int luces_encendidas_f1 = reloj.getHora() / VALOR_LUZ_ENCENDIDA;
		int luces_encendidas_f2 = reloj.getHora() % VALOR_LUZ_ENCENDIDA;
		int luces_encendidas_f3 = reloj.getMinutos() / VALOR_LUZ_ENCENDIDA;
		int luces_encendidas_f4 = reloj.getMinutos() % VALOR_LUZ_ENCENDIDA;

		// Pintar la fila0

		fila0 = (reloj.getSegundos() % 2 == 0 ? Luces.ROJO.getLuz() : Luces.AMARILLO.getLuz()) + "\n";

		// Pintar la fila1

		StringBuilder fila1 = armarFila(luces_encendidas_f1, Luces.ROJO.getLuz());

		// Pintar la fila2

		StringBuilder fila2 = armarFila(luces_encendidas_f2, Luces.ROJO.getLuz());

		// Pintar la fila3

		StringBuilder fila3 = armarFila3(luces_encendidas_f3);

		// Pintar la fila4

		StringBuilder fila4 = armarFila(luces_encendidas_f4, Luces.AMARILLO.getLuz());

		return respuesta.append(fila0).append(fila1).append(fila2).append(fila3).append(fila4);

	}

	// Metodo para armar la fila 3

	public StringBuilder armarFila3(int luces_encendidas) {
		StringBuilder fila = new StringBuilder();
		for (int i = 1; i <= luces_encendidas; i++) {
			if (i % DIVISIONES_FILA_3 == 0) {
				fila.append(Luces.ROJO.getLuz());
			} else {
				fila.append(Luces.AMARILLO.getLuz());
			}
		}
		if (luces_encendidas < LONGITUD_FILA_3) {

			fila = rellenarFila(fila, luces_encendidas, LONGITUD_FILA_3);

		}
		fila.append("\n");
		return fila;
	}

	// Metodo para armar una fila

	public StringBuilder armarFila(int luces_encendidas, String color) {
		StringBuilder fila = new StringBuilder();
		for (int i = 0; i < luces_encendidas; i++) {
			fila.append(color);
		}
		if (luces_encendidas < LONGITUD_FILAS_1_2_4) {
			fila = rellenarFila(fila, luces_encendidas, LONGITUD_FILAS_1_2_4);
		}
		fila.append("\n");
		return fila;
	}

	// Metodo para rellenar de luces apagadas una fila

	private StringBuilder rellenarFila(StringBuilder fila, int luces_encendidas, int cantidad_de_iteraciones) {

		for (int i = luces_encendidas; i < cantidad_de_iteraciones; i++) {
			fila.append(Luces.APAGADO.getLuz());
		}
		return fila;
	}

}
