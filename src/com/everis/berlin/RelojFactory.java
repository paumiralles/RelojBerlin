// Factory Reloj. Hace las comprobaciones i retorna un objeto Reloj si el input es válido

package com.everis.berlin;

import java.util.ArrayList;

public class RelojFactory {

	public static final String SEPARADOR = ":";

	public static Reloj crearReloj(String input) throws RelojException {

		ArrayList<String> errores = new ArrayList<String>();
		if (input.matches("\\d\\d:\\d\\d:\\d\\d")) {

			String[] parts = input.split(SEPARADOR);

			int hora = Integer.parseInt(parts[0]);
			int minutos = Integer.parseInt(parts[1]);
			int segundos = Integer.parseInt(parts[2]);

			if (hora < 0 || hora > 24) {
				errores.add("La hora no es posible");
			}
			if (minutos < 0 || minutos > 60) {
				errores.add("Los minutos no son posibles");
			}
			if (segundos < 0 || segundos > 60) {
				errores.add("Los segundos no son posibles");
			}

			if (!errores.isEmpty()) {
				throw new RelojException(errores);
			}
			return new Reloj(hora, minutos, segundos);

		}
		errores.add("El formato no es correcto, debe ser HH:MM:SS");
		throw new RelojException(errores);

	}
}
