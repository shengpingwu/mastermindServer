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

@Entity
public class RatingHistoric implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8010083719215550183L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ElementCollection
	@OneToMany(cascade={CascadeType.ALL})
	private List<RatingClass> historic;

	@OneToMany(targetEntity=RatingClass.class, mappedBy="rating", 
			fetch=FetchType.EAGER)
	public List<RatingClass> getHistoric() {
		return historic;
	}

	public void setHistoric(List<RatingClass> historic) {
		this.historic = historic;
	}
	
	public static RatingHistoric build(List<RatingClass> r) {
		RatingHistoric ratingHistoric = new RatingHistoric();
		ratingHistoric.setHistoric(r);
		return ratingHistoric;
	}

}
