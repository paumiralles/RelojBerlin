package com.everis.berlin;

public class RelojApp {

	public static void main(String[] string) {
		
		RelojBerlin relojBerlin = new RelojBerlin();

		try {

			String var1 = relojBerlin.obtenerReloj();

			Reloj var2 = relojBerlin.comprobar(var1);

			System.out.println(relojBerlin.imprimirReloj(var2));

		} catch (RelojException relojException) {
			
			System.out.println(relojException.getMessage());
		}

	}

	
}
