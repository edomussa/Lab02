package it.polito.tdp.alien.traduttore;

import java.util.*;

public class Parola {
	
	private String parola;
	//private String traduzione;
	private List<String> traduzioni;
	
	public Parola(String parola) {
		super();
		this.parola = parola;
		//this.traduzione = traduzione;
		traduzioni= new LinkedList<String>();
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	/*public String getTraduzione() {
		return traduzione;
	}

	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}*/
	
	public void aggiungiTraduzione(String s) {
		this.traduzioni.add(s);
	}

	public List<String> getTraduzioni() {
		return traduzioni;
	}
	
	

}
