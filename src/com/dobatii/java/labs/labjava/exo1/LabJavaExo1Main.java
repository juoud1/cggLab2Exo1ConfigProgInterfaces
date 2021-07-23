package com.dobatii.java.labs.labjava.exo1;

import static com.dobatii.java.labs.labjava.exo1.utils.cons.Constant.*;

import com.dobatii.java.labs.labjava.exo1.service.ResistanceService;

public class LabJavaExo1Main {
	
	public static void main(String[] args) throws Exception {
		
		ResistanceService r = new ResistanceService();
		Float resistance = r.calculerValeurResistance();
		
		System.out.println();
		System.out.println(LA_VALEUR_DE_LA_RÉSISTANCE.toUpperCase() + resistance.longValue() + V);
	}

}
