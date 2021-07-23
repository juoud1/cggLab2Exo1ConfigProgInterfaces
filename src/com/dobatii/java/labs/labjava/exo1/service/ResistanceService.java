package com.dobatii.java.labs.labjava.exo1.service;

import java.util.Scanner;

import com.dobatii.java.labs.labjava.exo1.utils.enums.CouleurEnum;
import com.dobatii.java.labs.labjava.exo1.utils.enums.TensionAlimentationEnum;
import com.dobatii.java.labs.labjava.exo1.utils.validation.DataValidation;

import static com.dobatii.java.labs.labjava.exo1.utils.cons.Constant.*;

/**
 * 
 * Proxy service pour le calcul de r�stance
 * http://fantaisyland.fr/calcul-resistance-led/
 * 
 * @author Juoud1
 *
 */

public class ResistanceService {
	
	// Variables pour recevoir les donn�es entr�es au clavier 
	private String couleurSaisie;
	private String tensionAlimentationSaisie;
	private String tensionLedSaisie;
	private String intensiteLedSaisie;
	
	// Donn�es pour le calcul de la valeur de r�sistance
	private CouleurEnum couleurLed;
	private TensionAlimentationEnum tensionAlimentation;
	private Float tensionLed;
	private Float intensiteLed;
	
	/**
	 * Constructeur
	 * @param lectureClavier
	 */
	public ResistanceService() {
		super();
		
		Scanner lectureClavier = new Scanner(System.in);
		
		System.out.println(SAISISSEZ_LA_COULEUR_DE_LED);
		couleurSaisie = lectureClavier.next();
		
		System.out.println(SAISISSEZ_LA_TENSION_D_ALIMENTATION);
        tensionAlimentationSaisie = lectureClavier.next();
        
        System.out.println(SAISISSEZ_LA_TENSION_DE_LA_LED);
        tensionLedSaisie = lectureClavier.next();
        
        System.out.println(SAISISSEZ_L_INTENSITE_DE_LA_LED);
        intensiteLedSaisie = lectureClavier.next();
        
        lectureClavier.close();
	}
	
	
	/**
	 * M�thode pour afficher � l'�cran toutes les donn�es saisies par l'utilisateur
	 * aucun param�tre
	 * @return aucune valeur 
	 * 
	 */
	private void afficherDonneesSaisies () {
		
		System.out.print(VOUS_AVEZ_SAISIE);
		System.out.println("------");
		
		System.out.println(COULEUR_DE_LED + couleurSaisie);
		System.out.println(TENSION_D_ALIMENTATION + tensionAlimentationSaisie);
		System.out.println(TENSION_DE_LED + tensionLedSaisie);
		System.out.println(INTENSITE_DE_LED + intensiteLedSaisie);
		System.out.println();
		
	}
	
	
	/**
	 * Valider les donn�es et V�rifier si la tension de Led est correcte
	 * aucun param�tre
	 * @return aucune valeur 
	 * 
	 */
	private Boolean traiterDonneesDeResistanceSuivantCouleur() {
	
		// On affiche les donn�es saisies
		afficherDonneesSaisies();
		
		// Validation des donn�es saisies
		System.out.println(VALIDATION_EN_COURS);
		couleurLed = DataValidation.validerCouleurLed(couleurSaisie);
		tensionAlimentation = DataValidation.validerTensionAlimentation(tensionAlimentationSaisie);
		tensionLed = DataValidation.validerTensionLed(tensionLedSaisie);
		intensiteLed = DataValidation.validerIntensiteLed(intensiteLedSaisie);
		System.out.println(VALIDATION_TERMINEE);
		
		// On v�rifie si les donn�es saisies sont valides pour le calcul de la valeur de la r�sistance
		if (couleurLed == null || tensionAlimentation == null || tensionLed == null || intensiteLed == null) {
			System.err.println(UNE_OU_PLUSIEURS_DONNEES_QUE_VOUS_AVEZ_SAISIES_SONT_NULL);
			return null;
		}
		
		System.out.println(TRAITEMENT_EN_COURS);
		
		boolean b = false;
		
		switch (couleurLed.getCouleurId()) {
		case 1:
		
		case 3:
			if (tensionLed >= 2.1f && tensionLed <= 2.3f) {
				b = true;
			}
			break;
		
		case 2:
			
		case 6:
			
		case 7:
			
		case 8:
			if (tensionLed >= 3.2f && tensionLed <= 3.4f) {
				b = true;
			}
			break;
			
		case 4:
			if (tensionLed >= 3.1f && tensionLed <= 3.3f) {
				b = true;
			}
			break;
		
		case 5:
			if (tensionLed >= 3.0f && tensionLed <= 3.2f) {
				b = true;
			}
			break;
			
		default:
			break;
		}
		
		System.out.println(TRAITEMENTS_TERMINES + b);
		
		return b;
	}
	
	/**
	 * Calcul de la r�sistance selon la formule R=(U-UI)/I
	 * @return un nombre d�cimal positif ou n�gatif(donn�es invalides)
	 * 
	 */
	public Float calculerValeurResistance() {
		
		System.out.print(ON_CALCULE_LA_VALEUR);
		// Si les donn�es de l'utilisateur sont valides
		return traiterDonneesDeResistanceSuivantCouleur() ? ((tensionAlimentation.getValeurTension() - tensionLed)/intensiteLed) : Float.MAX_VALUE;
		
	}

}
