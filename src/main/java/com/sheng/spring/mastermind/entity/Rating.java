package com.sheng.spring.mastermind.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {
	
	public static final int BLACK = 0; 
	public static final int WHITE = 1; 
	public static final int NONE = 2;
	
	
	public Rating() {
		
	}
	public Rating(int value) {
		this.value = value;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int value;
	/*
	public String getRating() {
		
		switch (value) {
		case 0: return "BLACK"; 
		case 1: return "WHITE"; 
		default: return "NONE"; 
		}
	}
	*/
	public int getValue() {
		return value; 
	}	
	public void setValue(int value) {
		this.value = value;
	}
	/*
	public void setRating(String rating) {
		
		if (rating.equalsIgnoreCase("BLACK")) {
			this.value = 0; 
		} else if (rating.equalsIgnoreCase("WHITE")) {
			this.value = 1; 
		} else {
			this.value = 2;
		}
	}
	*/
	public static Rating build(int value) {
		return new Rating(value);
	}
}
