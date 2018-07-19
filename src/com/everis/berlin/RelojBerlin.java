package com.everis.berlin;


public class RelojBerlin {

	private ImprimirReloj imprimirReloj;
	private ObtenerReloj obtenerReloj;
	
	public RelojBerlin() {
		imprimirReloj = new ImprimirReloj();
		obtenerReloj = new ObtenerReloj();
	}
	
	public RelojBerlin(ImprimirReloj imprimirReloj, ObtenerReloj obtenerReloj) {
		this.imprimirReloj = imprimirReloj;
		this.obtenerReloj = obtenerReloj;
	}
	
	public String obtenerReloj() {

		return obtenerReloj.inputReloj();

	}

	public Reloj comprobar(String list) throws RelojException {

		return RelojFactory.crearReloj(list);
		
	}

	public StringBuilder imprimirReloj(Reloj reloj) {

		return imprimirReloj.calcularLucesBerlin(reloj);
	}

}
