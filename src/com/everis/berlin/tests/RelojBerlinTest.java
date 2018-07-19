package com.everis.berlin.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.everis.berlin.ImprimirReloj;
import com.everis.berlin.ObtenerReloj;
import com.everis.berlin.Reloj;
import com.everis.berlin.RelojBerlin;
import com.everis.berlin.RelojException;

public class RelojBerlinTest {

	private RelojBerlin relojBerlin;
	private RelojBerlin mockedRelojBerlin;
	private ObtenerReloj obtenerReloj;
	private ImprimirReloj imprimirReloj;

	@Before
	public void setup() {

		obtenerReloj = Mockito.mock(ObtenerReloj.class);
		imprimirReloj = Mockito.mock(ImprimirReloj.class);
		relojBerlin = new RelojBerlin();
		mockedRelojBerlin = new RelojBerlin(imprimirReloj, obtenerReloj);
	}

	@Test
	public void testComprobarFunciona() throws RelojException {

		Reloj reloj = relojBerlin.comprobar("12:12:12");
		assertEquals(12, reloj.getHora());
		assertEquals(12, reloj.getMinutos());
		assertEquals(12, reloj.getSegundos());
	}

	@Test(expected = RelojException.class)
	public void testComprobarFalla() throws RelojException {
		Reloj reloj = relojBerlin.comprobar("45:12:12");

	}

	@Test
	public void testObtenerReloj() {
		Mockito.when(obtenerReloj.inputReloj()).thenReturn("12:12:12");
		String response = mockedRelojBerlin.obtenerReloj();
		assertEquals("12:12:12", response);
	}
	
	@Test 
	public void testImprimirReloj() {
		Reloj reloj = Mockito.mock(Reloj.class);
		mockedRelojBerlin.imprimirReloj(reloj);
		Mockito.verify(imprimirReloj,Mockito.times(1)).calcularLucesBerlin(Mockito.any(Reloj.class));
	}
}
