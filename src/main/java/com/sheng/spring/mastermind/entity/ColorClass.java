package com.sheng.spring.mastermind.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ColorClass {
	
	public static final int RED = 0;
	public static final int BLUE = 1; 
	public static final int GREEN = 2; 
	public static final int YELLOW = 3; 
	
	public static final int MAX_COLOR = 4;

	public ColorClass() {
		
	}
	
	public ColorClass(int value) {
		this.value = value;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int value;
	
	@Override
	public String toString() {
		
		return String.valueOf(value);
	}
	
	public int getValue() {
		return value; 
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	/*
	public void setColor(String color) {
		
		if (color.equalsIgnoreCase("RED")) {
			this.value = 0; 
		} else if (color.equalsIgnoreCase("BLUE")) {
			this.value = 1; 
		} else if (color.equalsIgnoreCase("GREEN")) {
			this.value = 2;
		} else if (color.equalsIgnoreCase("YELLOW")) {
			this.value = 3;
		}
	}
	*/	
	public static ColorClass build(int value) {
		return new ColorClass(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorClass other = (ColorClass) obj;
		if (value != other.value)
			return false;
		return true;
	}

	/*
	public boolean equals(ColorClass color) {
		
		if (color.getValue() == this.getValue()) {
			return true;
		}
		
		return false; 
	}
	*/
	
}
