package com.dobatii.java.labs.labjava.exo1.utils.enums;

/**
 * Énumération des tensions d'alimentation suivant :
 * http://fantaisyland.fr/calcul-resistance-led/
 * 
 * @author juoud1
 *
 */

public enum TensionAlimentationEnum {
	
	TENSION12V(12, "V"), 
	TENSION5V(5, "V");
	
	private Integer valeurTension;
	private String uniteMesureTension;

	private TensionAlimentationEnum() {
	}

	private TensionAlimentationEnum(Integer valeurTension, String uniteMesureTension) {
		this.valeurTension = valeurTension;
		this.uniteMesureTension = uniteMesureTension;
	}

	public Integer getValeurTension() {
		return valeurTension;
	}

	public String getUniteMesureTension() {
		return uniteMesureTension;
	}
	
}
