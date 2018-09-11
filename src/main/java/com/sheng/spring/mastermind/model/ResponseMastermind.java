package com.sheng.spring.mastermind.model;

import java.util.List;

import com.sheng.spring.mastermind.entity.CodeGuessHistoric;
import com.sheng.spring.mastermind.entity.MastermindGame;
import com.sheng.spring.mastermind.entity.RatingClass;
import com.sheng.spring.mastermind.entity.RatingHistoric;

public class ResponseMastermind {
	
	private Long id; 
	
	private List<RatingClass>  feedbackLastCheck; 
	
	private List<RatingHistoric> historicRating;

	private List<CodeGuessHistoric> historicCodeGuess;
		
	private String message; 
	
	private Boolean gameIsFinish;
	
	public static ResponseMastermind build(Long id, List<RatingHistoric> historicRating,
			List<CodeGuessHistoric> historicCodeGuess, String message, Boolean gameIsFinish) {
		
		ResponseMastermind responseMastermind = new ResponseMastermind();
		
		responseMastermind.setId(id);
		responseMastermind.setHistoricRating(historicRating);
		responseMastermind.setHistoricCodeGuess(historicCodeGuess);
		responseMastermind.setMessage(message);
		responseMastermind.setGameIsFinish(gameIsFinish);
		
		return responseMastermind;
	}
	
	public static ResponseMastermind build(MastermindGame mastermindGame, List<RatingClass> feedbackLastCheck, String message, Boolean gameIsFinish) {
		
		ResponseMastermind responseMastermind = new ResponseMastermind();
		
		responseMastermind.setId(mastermindGame.getId());
		responseMastermind.setHistoricRating(mastermindGame.getHistoricRating());
		responseMastermind.setHistoricCodeGuess(mastermindGame.getHistoricCodeGuess());
		responseMastermind.setMessage(message);
		responseMastermind.setGameIsFinish(gameIsFinish);
		responseMastermind.setFeedbackLastCheck(feedbackLastCheck);
		
		return responseMastermind;
	}
	
	/**
	 * @return the feedbackLastCheck
	 */
	public List<RatingClass> getFeedbackLastCheck() {
		return feedbackLastCheck;
	}

	/**
	 * @param feedbackLastCheck the feedbackLastCheck to set
	 */
	public void setFeedbackLastCheck(List<RatingClass> feedbackLastCheck) {
		this.feedbackLastCheck = feedbackLastCheck;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RatingHistoric> getHistoricRating() {
		return historicRating;
	}

	public void setHistoricRating(List<RatingHistoric> historicRating) {
		this.historicRating = historicRating;
	}

	public List<CodeGuessHistoric> getHistoricCodeGuess() {
		return historicCodeGuess;
	}

	public void setHistoricCodeGuess(List<CodeGuessHistoric> historicCodeGuess) {
		this.historicCodeGuess = historicCodeGuess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getGameIsFinish() {
		return gameIsFinish;
	}

	public void setGameIsFinish(Boolean gameIsFinish) {
		this.gameIsFinish = gameIsFinish;
	}	
}
