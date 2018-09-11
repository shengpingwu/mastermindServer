package com.sheng.spring.mastermind;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sheng.spring.mastermind.entity.ColorClass;
import com.sheng.spring.mastermind.entity.RatingClass;


public class MastermindManagerTest {

	private MastermindManager mastermindManager = new MastermindManager(); 
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Check correctamente la secuencia y verifica que la partida ha terminado.
	 */
	@Test
	public void test0001CheckSecuencyCorrectly() {
		
		List<ColorClass> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (ColorClass.build(ColorClass.BLUE));
		cipherGenerated.add (ColorClass.build(ColorClass.RED));
		cipherGenerated.add (ColorClass.build(ColorClass.GREEN));
		cipherGenerated.add (ColorClass.build(ColorClass.YELLOW));
		
		List<RatingClass> result = mastermindManager.checkSecuency(cipherGenerated, cipherGenerated);
		
		assertEquals(4, result.size());
		assertEquals(true, mastermindManager.gameIsOver(cipherGenerated, result));
	}
	
	/**
	 * Check la secuencia y obtiene dos fichas negras por coincidencias y sitio.
	 */
	@Test
	public void test0002CheckSecuencyHaveTwoBlackCodePeg() {
		
		List<ColorClass> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (ColorClass.build(ColorClass.BLUE));
		cipherGenerated.add (ColorClass.build(ColorClass.RED));
		cipherGenerated.add (ColorClass.build(ColorClass.GREEN));
		cipherGenerated.add (ColorClass.build(ColorClass.YELLOW));
		
		List<ColorClass> codeGuess = new ArrayList<>();
		codeGuess.add (ColorClass.build(ColorClass.BLUE));
		codeGuess.add (ColorClass.build(ColorClass.RED));
		codeGuess.add (ColorClass.build(ColorClass.RED));
		codeGuess.add (ColorClass.build(ColorClass.BLUE));
		
		List<RatingClass> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(2, result.size());
		assertEquals(RatingClass.BLACK, result.get(0).getValue());
		assertEquals(RatingClass.BLACK, result.get(1).getValue());
	}
	
	/**
	 * Check la secuencia y obtiene dos fichas blancas por coincidencias.
	 */
	@Test
	public void test0003CheckSecuencyHaveTwoWhiteCodePeg() {
		
		List<ColorClass> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (ColorClass.build(ColorClass.BLUE));
		cipherGenerated.add (ColorClass.build(ColorClass.RED));
		cipherGenerated.add (ColorClass.build(ColorClass.GREEN));
		cipherGenerated.add (ColorClass.build(ColorClass.YELLOW));
		
		List<ColorClass> codeGuess = new ArrayList<>();
		codeGuess.add (ColorClass.build(ColorClass.YELLOW));
		codeGuess.add (ColorClass.build(ColorClass.YELLOW));
		codeGuess.add (ColorClass.build(ColorClass.RED));
		codeGuess.add (ColorClass.build(ColorClass.RED));
		
		List<RatingClass> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(2, result.size());
		assertEquals(RatingClass.WHITE, result.get(0).getValue());
		assertEquals(RatingClass.WHITE, result.get(1).getValue());
	}

	/**
	 * Check la secuencia y obtiene dos fichas blancas por coincidencias y dos negras.
	 */
	@Test
	public void test0004CheckSecuencyHaveTwoWhiteAndTwoBlackCodePeg() {
		
		List<ColorClass> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (ColorClass.build(ColorClass.BLUE));
		cipherGenerated.add (ColorClass.build(ColorClass.RED));
		cipherGenerated.add (ColorClass.build(ColorClass.GREEN));
		cipherGenerated.add (ColorClass.build(ColorClass.YELLOW));
		
		List<ColorClass> codeGuess = new ArrayList<>();
		codeGuess.add (ColorClass.build(ColorClass.BLUE));
		codeGuess.add (ColorClass.build(ColorClass.YELLOW));
		codeGuess.add (ColorClass.build(ColorClass.GREEN));
		codeGuess.add (ColorClass.build(ColorClass.RED));
		
		List<RatingClass> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(4, result.size());
		assertEquals(Long.valueOf(2), result.stream().filter((r) -> r.getValue() == RatingClass.WHITE).count());
		assertEquals(Long.valueOf(2), result.stream().filter((r) -> r.getValue() == RatingClass.BLACK).count());

	}
	
	/**
	 * Check la secuencia y no tiene ninguna ficha.
	 */
	@Test
	public void test0005CheckSecuencyNotHaveCodePeg() {
		
		List<ColorClass> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (ColorClass.build(ColorClass.YELLOW));
		cipherGenerated.add (ColorClass.build(ColorClass.RED));
		cipherGenerated.add (ColorClass.build(ColorClass.GREEN));
		cipherGenerated.add (ColorClass.build(ColorClass.YELLOW));
		
		List<ColorClass> codeGuess = new ArrayList<>();
		codeGuess.add (ColorClass.build(ColorClass.BLUE));
		codeGuess.add (ColorClass.build(ColorClass.BLUE));
		codeGuess.add (ColorClass.build(ColorClass.BLUE));
		codeGuess.add (ColorClass.build(ColorClass.BLUE));
		
		List<RatingClass> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(0, result.size());

	}
}
