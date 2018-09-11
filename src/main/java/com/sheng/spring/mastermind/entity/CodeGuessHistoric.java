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
public class CodeGuessHistoric implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8193431380699237548L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ElementCollection
	@OneToMany(cascade={CascadeType.ALL})
	private List<ColorClass> historic;

	
	@OneToMany(targetEntity=ColorClass.class, mappedBy="codeguess", 
			fetch=FetchType.EAGER)
	public List<ColorClass> getHistoric() {
		return historic;
	}
	
	public void setHistoric(List<ColorClass> historic) {
		this.historic = historic;
	}
	
	public static CodeGuessHistoric build(List<ColorClass> r) {
		CodeGuessHistoric codeH = new CodeGuessHistoric();
		codeH.setHistoric(r);
		
		return codeH;
	}

}
