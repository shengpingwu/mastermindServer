package com.sheng.spring.mastermind;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sheng.spring.mastermind.entity.Color;
import com.sheng.spring.mastermind.entity.Rating;


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
		
		List<Color> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (Color.build(Color.BLUE));
		cipherGenerated.add (Color.build(Color.RED));
		cipherGenerated.add (Color.build(Color.GREEN));
		cipherGenerated.add (Color.build(Color.YELLOW));
		
		List<Rating> result = mastermindManager.checkSecuency(cipherGenerated, cipherGenerated);
		
		assertEquals(4, result.size());
		assertEquals(true, mastermindManager.gameIsOver(cipherGenerated, result));
	}
	
	/**
	 * Check la secuencia y obtiene dos fichas negras por coincidencias y sitio.
	 */
	@Test
	public void test0002CheckSecuencyHaveTwoBlackCodePeg() {
		
		List<Color> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (Color.build(Color.BLUE));
		cipherGenerated.add (Color.build(Color.RED));
		cipherGenerated.add (Color.build(Color.GREEN));
		cipherGenerated.add (Color.build(Color.YELLOW));
		
		List<Color> codeGuess = new ArrayList<>();
		codeGuess.add (Color.build(Color.BLUE));
		codeGuess.add (Color.build(Color.RED));
		codeGuess.add (Color.build(Color.RED));
		codeGuess.add (Color.build(Color.BLUE));
		
		List<Rating> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(2, result.size());
		assertEquals(Rating.BLACK, result.get(0).getValue());
		assertEquals(Rating.BLACK, result.get(1).getValue());
	}
	
	/**
	 * Check la secuencia y obtiene dos fichas blancas por coincidencias.
	 */
	@Test
	public void test0003CheckSecuencyHaveTwoWhiteCodePeg() {
		
		List<Color> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (Color.build(Color.BLUE));
		cipherGenerated.add (Color.build(Color.RED));
		cipherGenerated.add (Color.build(Color.GREEN));
		cipherGenerated.add (Color.build(Color.YELLOW));
		
		List<Color> codeGuess = new ArrayList<>();
		codeGuess.add (Color.build(Color.YELLOW));
		codeGuess.add (Color.build(Color.YELLOW));
		codeGuess.add (Color.build(Color.RED));
		codeGuess.add (Color.build(Color.RED));
		
		List<Rating> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(2, result.size());
		assertEquals(Rating.WHITE, result.get(0).getValue());
		assertEquals(Rating.WHITE, result.get(1).getValue());
	}

	/**
	 * Check la secuencia y obtiene dos fichas blancas por coincidencias y dos negras.
	 */
	@Test
	public void test0004CheckSecuencyHaveTwoWhiteAndTwoBlackCodePeg() {
		
		List<Color> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (Color.build(Color.BLUE));
		cipherGenerated.add (Color.build(Color.RED));
		cipherGenerated.add (Color.build(Color.GREEN));
		cipherGenerated.add (Color.build(Color.YELLOW));
		
		List<Color> codeGuess = new ArrayList<>();
		codeGuess.add (Color.build(Color.BLUE));
		codeGuess.add (Color.build(Color.YELLOW));
		codeGuess.add (Color.build(Color.GREEN));
		codeGuess.add (Color.build(Color.RED));
		
		List<Rating> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(4, result.size());
		assertEquals(Long.valueOf(2), result.stream().filter((r) -> r.getValue() == Rating.WHITE).count());
		assertEquals(Long.valueOf(2), result.stream().filter((r) -> r.getValue() == Rating.BLACK).count());

	}
	
	/**
	 * Check la secuencia y no tiene ninguna ficha.
	 */
	@Test
	public void test0005CheckSecuencyNotHaveCodePeg() {
		
		List<Color> cipherGenerated = new ArrayList<>();
		cipherGenerated.add (Color.build(Color.YELLOW));
		cipherGenerated.add (Color.build(Color.RED));
		cipherGenerated.add (Color.build(Color.GREEN));
		cipherGenerated.add (Color.build(Color.YELLOW));
		
		List<Color> codeGuess = new ArrayList<>();
		codeGuess.add (Color.build(Color.BLUE));
		codeGuess.add (Color.build(Color.BLUE));
		codeGuess.add (Color.build(Color.BLUE));
		codeGuess.add (Color.build(Color.BLUE));
		
		List<Rating> result = mastermindManager.checkSecuency(cipherGenerated, codeGuess);
		
		assertEquals(0, result.size());

	}
}
