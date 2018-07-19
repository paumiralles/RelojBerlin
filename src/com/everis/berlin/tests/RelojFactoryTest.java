package com.everis.berlin.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import com.everis.berlin.Reloj;
import com.everis.berlin.RelojException;
import com.everis.berlin.RelojFactory;

public class RelojFactoryTest {
	
	

	@Test(expected = RelojException.class)
	public void testFormatoHoraNoCorrecto() throws RelojException {
		Reloj reloj = RelojFactory.crearReloj("1:12:12");
		fail();
	}

	@Test(expected = RelojException.class)
	public void testHoraNoCorrecto() throws RelojException {
		Reloj reloj = RelojFactory.crearReloj("91:12:12");
		fail();
	}

	@Test(expected = RelojException.class)
	public void testMinutosNoCorrecto() throws RelojException {
		Reloj reloj = RelojFactory.crearReloj("12:91:12");
		fail();
	}

	@Test(expected= RelojException.class)
	public void testSegundosNoCorrecto() throws RelojException {
		Reloj reloj = RelojFactory.crearReloj("12:12:91");
		fail();
	}


@Test
	public void testFormatoHoraCorrecto() throws RelojException{
		Reloj reloj = RelojFactory.crearReloj("12:12:12");
		assertEquals(12, reloj.getHora());
		assertEquals(12, reloj.getMinutos());
		assertEquals(12, reloj.getSegundos());
}}