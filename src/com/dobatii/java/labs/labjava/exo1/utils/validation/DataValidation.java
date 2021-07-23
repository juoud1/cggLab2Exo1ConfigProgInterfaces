package com.dobatii.java.labs.labjava.exo1.utils.validation;

import java.util.Arrays;

import com.dobatii.java.labs.labjava.exo1.utils.enums.CouleurEnum;
import com.dobatii.java.labs.labjava.exo1.utils.enums.TensionAlimentationEnum;

/**
 * Utilitaire de validation des donn�es saisies par l'utilisateurs
 * Ces donn�es sont couleur et la tension Led
 * 
 * @author Juoud1
 *
 */

public final class DataValidation {
	
	public static Float validerTensionLed (String tensionLed) {
		
		try {
			return Float.parseFloat(tensionLed);
			
		}  catch (NumberFormatException nfe) {
			System.err.println("Tension de Led doit �tre un nombre d�cimal : " + nfe.getLocalizedMessage());
			
		}
		return null;
	}
	
	public static CouleurEnum validerCouleurLed(String tensionLed) {
			
		return Arrays.asList(CouleurEnum.values()).stream()
					.filter(c -> c.getCouleurName().equalsIgnoreCase(tensionLed))
					.findFirst()
					.orElseGet(null);
		
	}
	
	public static TensionAlimentationEnum validerTensionAlimentation (String tensionAlimentation) {
		
		try {
			int tension = Integer.parseInt(tensionAlimentation);
			
			return Arrays.asList(TensionAlimentationEnum.values()).stream()
						.filter(t -> t.getValeurTension().intValue() == tension)
						.findFirst()
						.orElseGet(null);
			
		}  catch (IllegalArgumentException nfe) {
			System.err.println("Tension alimentation doit �tre 5 ou 12 : " + nfe.getLocalizedMessage());
			
		}
		return null;
	}
	
	public static Float validerIntensiteLed (String intensiteLed) {
		
		try {
			return Float.parseFloat(intensiteLed);
			
		}  catch (NumberFormatException nfe) {
			System.err.println("Intensit� de Led doit �tre un nombre d�cimal : " + nfe.getLocalizedMessage());
			
		}
		return null;
	}

}
