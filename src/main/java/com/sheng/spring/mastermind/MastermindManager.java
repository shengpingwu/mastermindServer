package com.sheng.spring.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.hibernate.mapping.Array;
import org.springframework.stereotype.Component;

import com.sheng.spring.mastermind.entity.ColorClass;
import com.sheng.spring.mastermind.entity.RatingClass;

@Component
public class MastermindManager {

	public MastermindManager() {
		
	}
	
	/**
	 * Genera una secuencia de colores del juegos. 
	 * 
	 * @return
	 */
	public List<ColorClass> generatedSecuency() {
		List<ColorClass> result = new ArrayList<>();
		
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < ColorClass.MAX_COLOR; i++) {
			result.add(ColorClass.build(random.nextInt(ColorClass.MAX_COLOR)));
		}
		
		return result;
	}
	
	/**
	 * Chequea la secuencia introducida por el usuario con el guarda. Devolviendo una lista con colores negros y blancos.
	 * 
	 * @param guessSecuency
	 * @return
	 */
	public List<RatingClass> checkSecuency(List<ColorClass> cipherGenerated, List<ColorClass> guessSecuency) {
		
		List<RatingClass> result = new ArrayList<>();
		List<ColorClass> cipherGeneratedAux = new ArrayList<>();
		List<ColorClass> guessSecuencyAux = new ArrayList<>();
		
		// Recorrer la lista comparando cada uno. 
		for (int index = 0; index < cipherGenerated.size(); index++) { 
			if (cipherGenerated.get(index).equals(guessSecuency.get(index))) {
				//Si son iguales anadir una bola roja/negra a la lista de salida. 
				result.add(RatingClass.build(RatingClass.BLACK));
			} else {
				//Sino los guardamos los dos colores para un posterior analisis.
				cipherGeneratedAux.add(cipherGenerated.get(index));
				guessSecuencyAux.add(guessSecuency.get(index));
			}
		}
		
		//Recorrer la lista de guess y comparar si en el cipher tiene el color. Si lo tiene poner un blanco, eliminar ese color de la lista.
		for (ColorClass color: guessSecuencyAux) {
			if (cipherGeneratedAux.indexOf(color) != -1) {
				result.add(RatingClass.build(RatingClass.WHITE));
				cipherGeneratedAux.remove(color);
			}
		}
		// Devolver lista de rojos y blanco. Si todos son rojos se ha hayado la solucion.
		
		return result;
	}
	
	/**
	 * Chequea si el juego ha terminado.
	 * 
	 * @param resultPreviousCheck lista de fichas negras o blancas.
	 * @return
	 */
	public boolean gameIsOver(List<ColorClass> cipherGenerated, List<RatingClass> resultPreviousCheck) {
		
		//Filtramos los resultados de color Negro.
		resultPreviousCheck.stream().filter(r -> r.getValue() == RatingClass.BLACK);
		
		// Si la cantidad de negros coincide con la cantidad de fichas, la partida ha terminado.		
		if (resultPreviousCheck.size() == cipherGenerated.size()) {
			return true;
		} 
		
		return false;
	}
}
