package com.santhosh.changemachine;

import com.santhosh.constants.Constants;

public class ChangeMachine {
	
	public enum Denomination{
		PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
	
		private int denomValue; 
	
		private Denomination(int denomValue){
			this.denomValue = denomValue;
		}
	}
	
	int PENNY = 0;
	int NICKEL = 0;
	int DIME = 0;
	int QUARTER = 0;
	
	int totalPenny;
	int totalNickel;
	int totalDime;
	int totalQuarter;
	
	public ChangeMachine(){
		for(Denomination denom : Denomination.values()){
			switch(denom){
			case PENNY:
				PENNY = denom.denomValue;
				break;
			case NICKEL:
				NICKEL = denom.denomValue;
				break;
			case DIME:
				DIME = denom.denomValue;
				break;
			case QUARTER:
				QUARTER = denom.denomValue;
				break;
			}
		}
	}
	
	public void getDenominationBreakUp(int iInputCentsAmount){
		if(iInputCentsAmount!=0 && (iInputCentsAmount / QUARTER) == 0){
			totalQuarter = iInputCentsAmount / QUARTER;
		} else {
			totalQuarter = iInputCentsAmount / QUARTER;
			iInputCentsAmount = iInputCentsAmount % QUARTER;
		}
		
		if(iInputCentsAmount!=0 && (iInputCentsAmount / DIME) == 0){
			totalDime = iInputCentsAmount / DIME;
		} else {
			totalDime = iInputCentsAmount / DIME;
			iInputCentsAmount = iInputCentsAmount % DIME;
		}
		
		if(iInputCentsAmount!=0 && (iInputCentsAmount / NICKEL) == 0){
			totalNickel = iInputCentsAmount / NICKEL;
		} else {
			totalNickel = iInputCentsAmount / NICKEL;
			iInputCentsAmount = iInputCentsAmount % NICKEL;
		}
		
		if(iInputCentsAmount!=0 && (iInputCentsAmount / PENNY) == 0){
			totalPenny = iInputCentsAmount / PENNY;
		} else {
			totalPenny = iInputCentsAmount / PENNY;
			iInputCentsAmount = iInputCentsAmount % PENNY;
		}
		
		System.out.println("Left out amount "+iInputCentsAmount);
		System.out.println("Total Quarters "+totalQuarter);
		System.out.println("Total Dimes "+totalDime);
		System.out.println("Total Nickels "+totalNickel);
		System.out.println("Total Pennies "+totalPenny);

	}

}
