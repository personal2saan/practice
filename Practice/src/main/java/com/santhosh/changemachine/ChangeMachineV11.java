package com.santhosh.changemachine;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

public class ChangeMachineV11 {

//defining constants
	public enum Denomination{
		PENNY(1), NICKEL(5),DIME(10),QUARTER(25);
	
		private int denomValue;
		
		private Denomination(int denomValue){
			this.denomValue = denomValue;
		}
	}
	
//constructor to populate initiate enum constants
	
	int penny;
	int nickel;
	int dime;
	int quarter;
	
	int totalPenny;
	int totalNickel;
	int totalDime;
	int totalQuarter; 
	
	int availablePenny;
	int availableNickel;
	int availableDime;
	int availableQuarter;
	
	GetPropertyValues prop = new GetPropertyValues();
	
	public ChangeMachineV11(){
		for(Denomination denom : Denomination.values()){
			switch(denom){
			case PENNY : 
				penny = denom.denomValue; 
				break;
			case NICKEL:
				nickel = denom.denomValue;
				break;
			case DIME:
				dime = denom.denomValue;
				break;
			case QUARTER:
				quarter = denom.denomValue;
				break;
			}
		}
	}
	
//method get change
	
	//method get change with limits
	
	private void parseAvailableDenom(String inHandDenom) throws InvalidDenominatorException{
		
		StringTokenizer st = new StringTokenizer(inHandDenom, ",");
		String token[] = new String[st.countTokens()];
		
		System.out.println("st.countTokens() : "+st.countTokens());
		
		int length = st.countTokens();
		
		for(int i=0; i<length; i++){
			token[i] = st.nextToken();
		}
				
		for(int i=0; i<token.length; i++){
			String stByDenom[] = token[i].split("\\*");
			
			System.out.println("stByDenom[0] : "+stByDenom[0]);
			
			if(stByDenom[0].equals("PENNY")){
				availablePenny = new Integer(stByDenom[1]).intValue();
			} else if(stByDenom[0].equals("NICKEL")){
				availableNickel = new Integer(stByDenom[1]).intValue();				
			} else if(stByDenom[0].equals("DIME")){
				availableDime = new Integer(stByDenom[1]).intValue();
			} else if(stByDenom[0].equals("QUARTER")){
				availableQuarter = new Integer(stByDenom[1]).intValue();
			} else {
				System.out.println(prop.getPropValues("exception.denom.message"));
				throw new InvalidDenominatorException("Invaild Denom Token Name. Please ensure valid Denominator token name is providedn in input");
			}
		
		}
				
	}
	

	public void getChangeByDenom(int cents){
		
		if(cents > 0 && (cents / quarter) == 0){
			totalQuarter = (cents / quarter);
		}
		else {
			totalQuarter = (cents / quarter);	
			cents = cents % quarter;
		}

		if(cents > 0 && (cents / dime) == 0){
			totalDime = (cents / dime);
		}
		else {
			totalDime = (cents / dime);	
			cents = cents % dime;
		}
		
		if(cents > 0 && (cents / nickel) == 0){
			totalNickel = (cents / nickel);
		}
		else {
			totalNickel = (cents / nickel);	
			cents = cents % nickel;
		}
		
		if(cents > 0 && (cents / penny) == 0){
			totalPenny = (cents / penny);
		}
		else {
			totalPenny = (cents / penny);	
			cents = cents % penny;
		}
		
		if (cents > 0){
			System.out.println("Left out cents that did not match the denominations: "+cents);
		}
		

		
		if(availableQuarter > 0 && totalQuarter > availableQuarter){
			totalQuarter = availableQuarter;
			cents = cents - (availableQuarter * Denomination.QUARTER.denomValue);
		}
		
		if(availableDime > 0 && totalDime > availableDime){
			totalDime = availableDime;
			cents = cents - (availableDime * Denomination.DIME.denomValue);
		}
		
		if(availableNickel > 0 && totalNickel > availableNickel){
			totalNickel = availableNickel;
			cents = cents - (availableNickel * Denomination.NICKEL.denomValue);
		}
		
		if(availablePenny> 0 && totalPenny > availablePenny){
			totalPenny = availablePenny;
			cents = cents - (availablePenny * Denomination.PENNY.denomValue);
		}
		
		System.out.println("Total Quarter coins : "+totalQuarter);
		System.out.println("Total Dime coins : "+totalDime);
		System.out.println("Total Nickel coins : "+totalNickel);
		System.out.println("Total Penny coins : "+totalPenny);
	
	}
		
	public void getChangeByDenomWithLimit(int cents, String inHandDenom) throws InvalidDenominatorException{
		try {
			parseAvailableDenom(inHandDenom);
		} catch (InvalidDenominatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getChangeByDenom(cents);
	}
	

	public static void main(String args[]){
		ChangeMachineV11 change = new ChangeMachineV11();
		
		
		
		//change.getChangeByDenom(290);
		
		//String inhand = "QUARTER*5,DIME*10,NICKEL*15,PENNY*4";
		String inhand = "abc*100";
		try {
			change.getChangeByDenomWithLimit(299, inhand);
		} catch (InvalidDenominatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
