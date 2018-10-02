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
	private List<Color> historic;

	
	@OneToMany(targetEntity=Color.class, mappedBy="codeguess", 
			fetch=FetchType.EAGER)
	public List<Color> getHistoric() {
		return historic;
	}
	
	public void setHistoric(List<Color> historic) {
		this.historic = historic;
	}
	
	public static CodeGuessHistoric build(List<Color> r) {
		CodeGuessHistoric codeH = new CodeGuessHistoric();
		codeH.setHistoric(r);
		
		return codeH;
	}

}
