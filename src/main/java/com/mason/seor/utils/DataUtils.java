package com.mason.seor.utils;

public class DataUtils {
	
	/**
	 * Checks the program element for DoD program 6 and BA from 2-4
	 */
	public static boolean isValidPe(Object item){
		
		Integer dodProgram;
		Integer ba;
		
		if(item instanceof com.mason.seor.model.r1.ProgramElement){
			com.mason.seor.model.r1.ProgramElement r1 = (com.mason.seor.model.r1.ProgramElement) item;
			dodProgram = Integer.valueOf(r1.getPe().substring(0, 2));
			ba = Integer.valueOf(r1.getPe().substring(2, 4));
		} else{
			com.mason.seor.model.r2.ProgramElement r2 = (com.mason.seor.model.r2.ProgramElement) item;
			dodProgram = Integer.valueOf(r2.getProgramElementNumber().substring(0, 2));
			ba = Integer.valueOf(r2.getProgramElementNumber().substring(2, 4));
		}

		// we are only interested in BA's 2-4. All others can be disregarded
		if (ba < 2 || ba > 4) {
			return false;
		}
		// we only want RDT&E D0D program which is program number 6
		if (dodProgram != 6) {
			return false;
		}
		return true;
	}

}
