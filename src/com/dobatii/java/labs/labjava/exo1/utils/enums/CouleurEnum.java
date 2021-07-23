package com.dobatii.java.labs.labjava.exo1.utils.enums;

/**
 * Enumération des couleurs suivant 
 * http://fantaisyland.fr/calcul-resistance-led/
 * 
 * @author Juoud1
 *
 */

public enum CouleurEnum {
	
	ROUGE(1, "Rouge"), 
	ORANGE(2, "Orange"), 
	JAUNE(3, "Jaune"), 
	VERT(4, "Vert"), 
	BLEU(5, "Bleu"), 
	ROSE(6, "Rose"), 
	UV(7, "UV"),
	BLANC(8, "Blanc");
	
	private int couleurId;
	private String couleurName;
	
	private CouleurEnum() {
		
	}
	private CouleurEnum(int couleurId, String couleurName) {
		this.couleurId = couleurId;
		this.couleurName = couleurName;
	}

	public int getCouleurId() {
		return couleurId;
	}

	public String getCouleurName() {
		return couleurName;
	}
	
}
