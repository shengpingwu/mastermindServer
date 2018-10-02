package com.sheng.spring.mastermind.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MASTERMIND_GAME")
public class MastermindGame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8275131508618745299L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ElementCollection
	@OneToMany(cascade={CascadeType.ALL})
	private List<Color> cipherGenerated; 
	
	@ElementCollection
	@OneToMany(cascade={CascadeType.ALL})
	private List<RatingHistoric> historicRating;

	@ElementCollection
	@OneToMany(cascade={CascadeType.ALL})
	private List<CodeGuessHistoric> historicCodeGuess;

	public Long getId() {
		return id;
	}
	/**
	 * @return the cipherGenerated
	 */
	@OneToMany(targetEntity=Color.class, mappedBy="color", 
			fetch=FetchType.EAGER)
	public List<Color> getCipherGenerated() {
		return cipherGenerated;
	}

	/**
	 * @param cipherGenerated the cipherGenerated to set
	 */
	public void setCipherGenerated(List<Color> cipherGenerated) {
		this.cipherGenerated = cipherGenerated;
	}
	
	/**
	 * @return the historicRating
	 */
	@OneToMany(targetEntity=RatingHistoric.class, mappedBy="rating", 
			fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	public List<RatingHistoric> getHistoricRating() {
		return historicRating;
	}

	/**
	 * @param historicRating the historicRating to set
	 */
	public void setHistoricRating(List<RatingHistoric> historicRating) {
		this.historicRating = historicRating;
	}

		
	/**
	 * @return the historicCodeGuess
	 */
	@OneToMany(targetEntity=CodeGuessHistoric.class, mappedBy="rating", 
			fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	public List<CodeGuessHistoric> getHistoricCodeGuess() {
		return historicCodeGuess;
	}

	/**
	 * @param historicCodeGuess the historicCodeGuess to set
	 */
	public void setHistoricCodeGuess(List<CodeGuessHistoric> historicCodeGuess) {
		this.historicCodeGuess = historicCodeGuess;
	}
}