//De esta clase se retorna un String con el input de la hora

package com.everis.berlin;

import java.util.Scanner;

public class ObtenerReloj {

	private Scanner entrada;

	public ObtenerReloj() {
		entrada = new Scanner(System.in);
	}

	public String inputReloj() {
		System.out.println("Que hora es?");
		return entrada.next();
	}	
	
	public void close() {
		entrada.close();
	}
}
