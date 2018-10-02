package com.sheng.spring.mastermind.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheng.spring.mastermind.MastermindManager;
import com.sheng.spring.mastermind.entity.CodeGuessHistoric;
import com.sheng.spring.mastermind.entity.Color;
import com.sheng.spring.mastermind.entity.IMastermindGameRepository;
import com.sheng.spring.mastermind.entity.MastermindGame;
import com.sheng.spring.mastermind.entity.Rating;
import com.sheng.spring.mastermind.entity.RatingHistoric;
import com.sheng.spring.mastermind.model.ResponseMastermind;

@RestController
@RequestMapping("v1")
public class GameController {

	private final IMastermindGameRepository mastermindGameRepository; 
	private final MastermindManager mastermindManager;
	
	GameController(IMastermindGameRepository mastermindGameRepository, MastermindManager mastermindManager) {		
		this.mastermindGameRepository = mastermindGameRepository;
		this.mastermindManager = mastermindManager;
	}
	
	@GetMapping("/mastermind")
	public ResponseEntity<ResponseMastermind> createGame() {

		List<Rating> ratingResult = new ArrayList<>();
		List<RatingHistoric> historicRating = new ArrayList<>();
		List<CodeGuessHistoric> historicCodeGuess =new ArrayList<>();
		MastermindGame mastermindGame = new MastermindGame();
		mastermindGame.setCipherGenerated(mastermindManager.generatedSequence());
		mastermindGame.setHistoricCodeGuess(historicCodeGuess);
		mastermindGame.setHistoricRating(historicRating);		

		MastermindGame newMastermindGame = mastermindGameRepository.save(mastermindGame);

		return new ResponseEntity<ResponseMastermind>(
				ResponseMastermind.build(newMastermindGame,  ratingResult, "Game " + newMastermindGame.getId() + " created...", false),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/mastermind/{id}/historic")
	public ResponseEntity<ResponseMastermind> retrieveHistoric(@PathVariable Long id) {
		
		List<Rating> ratingResult = new ArrayList<>();
		
		Optional<MastermindGame> mastermindGame = mastermindGameRepository.findById(id);
		
		if (!mastermindGame.isPresent()) {
			return new ResponseEntity<ResponseMastermind>(HttpStatus.NOT_FOUND);	
		}
		
		
		return new ResponseEntity<ResponseMastermind>(ResponseMastermind.build(mastermindGame.get(),  ratingResult, "Game Historic is retrieve...", false), HttpStatus.OK);
		
	}
	
	@PostMapping("/mastermind/{id}")
	public ResponseEntity<ResponseMastermind> checkCodeGuess(@RequestBody List<Color> codeGuess, @PathVariable Long id) {
		
		Optional<MastermindGame> mastermindGame = mastermindGameRepository.findById(id);
		
		if (!mastermindGame.isPresent()) {
			return new ResponseEntity<ResponseMastermind>(HttpStatus.NOT_FOUND);	
		}
		
		MastermindGame currentMastermindGame = mastermindGame.get();
		
		List<Rating> ratingResult = mastermindManager.checkSecuency(currentMastermindGame.getCipherGenerated(), codeGuess);
		Boolean gameIsFinish = mastermindManager.gameIsOver(currentMastermindGame.getCipherGenerated(), ratingResult);
		
		currentMastermindGame.getHistoricCodeGuess().add(CodeGuessHistoric.build(codeGuess));
		currentMastermindGame.getHistoricRating().add(RatingHistoric.build(ratingResult));
		
		mastermindGameRepository.save(currentMastermindGame);
		
		return new ResponseEntity<ResponseMastermind>(ResponseMastermind.build(currentMastermindGame, ratingResult,  "Game feedback...", gameIsFinish), HttpStatus.OK);
		
	}
	
}
