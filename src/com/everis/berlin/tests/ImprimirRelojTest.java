package com.everis.berlin.tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.everis.berlin.ImprimirReloj;
import com.everis.berlin.Luces;
import com.everis.berlin.Reloj;
import com.everis.berlin.RelojException;

public class ImprimirRelojTest {

	private ImprimirReloj imprimirReloj;

	@Before
	public void setup() {
		imprimirReloj = new ImprimirReloj();

	}

	@Test
	public void testImprimirRespuestaHoraMin() {
		StringJoiner respuesta = new StringJoiner("\n");
		respuesta.add("R ").add("O O O O ").add("O O O O ").add("O O O O O O O O O O O ").add("O O O O \n");
		StringBuilder resultado = imprimirReloj.calcularLucesBerlin(new Reloj(00, 00, 00));
		assertEquals(respuesta.toString(), resultado.toString());

	}
	
	@Test
	public void testImprimirRespuestaHoraMax() {
		StringJoiner respuesta = new StringJoiner("\n");
		respuesta.add("Y ").add("R R R R ").add("R R R O ").add("Y Y R Y Y R Y Y R Y Y ").add("Y Y Y Y \n");
		StringBuilder resultado = imprimirReloj.calcularLucesBerlin(new Reloj(23, 59, 59));
		assertEquals(respuesta.toString(), resultado.toString());

	}
	
	@Test(expected = AssertionError.class )
	public void testImprimirRespuestaFormatoErroneo() throws AssertionError {
		StringBuilder resultado = imprimirReloj.calcularLucesBerlin(new Reloj(53, 59, 59));
		fail();

	}

	@Test
	public void testArmarFilaWhen3LucesEncendidas() {

		StringBuilder respuesta = imprimirReloj.armarFila(3, Luces.ROJO.getLuz());
		int countR = contar(Luces.ROJO.getLuz(), respuesta);
		int countO = contar(Luces.APAGADO.getLuz(), respuesta);
		assertEquals(3, countR);
		assertEquals(1, countO);
	}

	@Test
	public void testArmarFila3When3LucesEncendidas() {

		StringBuilder respuesta = imprimirReloj.armarFila3(3);
		int countR = contar(Luces.ROJO.getLuz(), respuesta);
		int countY = contar(Luces.AMARILLO.getLuz(), respuesta);
		int countO = contar(Luces.APAGADO.getLuz(), respuesta);
		assertEquals(1, countR);
		assertEquals(2, countY);
		assertEquals(8, countO);
	}
	
	@Test
	public void testArmarFila3When6LucesEncendidas() {

		StringBuilder respuesta = imprimirReloj.armarFila3(6);
		int countR = contar(Luces.ROJO.getLuz(), respuesta);
		int countY = contar(Luces.AMARILLO.getLuz(), respuesta);
		int countO = contar(Luces.APAGADO.getLuz(), respuesta);
		assertEquals(2, countR);
		assertEquals(4, countY);
		assertEquals(5, countO);
	}

	public void testArmarFila3When9LucesEncendidas() {

		StringBuilder respuesta = imprimirReloj.armarFila3(3);
		int countR = contar(Luces.ROJO.getLuz(), respuesta);
		int countY = contar(Luces.AMARILLO.getLuz(), respuesta);
		int countO = contar(Luces.APAGADO.getLuz(), respuesta);
		assertEquals(3, countR);
		assertEquals(6, countY);
		assertEquals(2, countO);
	}

	public int contar(String letra, StringBuilder palabra) {
		return StringUtils.countMatches(palabra.toString(), letra);

	}
}
