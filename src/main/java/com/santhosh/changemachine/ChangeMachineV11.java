package com.santhosh.changemachine;

import java.util.HashMap;
import java.util.Map;
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
	
	int availblePenny;
	int availableNickel;
	int availableDime;
	int availableQuarter;
	
	private ChangeMachineV11(){
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
		
		System.out.println("Total Quarter coins : "+totalQuarter);
		System.out.println("Total Dime coins : "+totalDime);
		System.out.println("Total Nickel coins : "+totalNickel);
		System.out.println("Total Penny coins : "+totalPenny);
	
	}
	
//method get change with limits
	
	private Map<String, Integer> parseAvailableDenom(String inHandDenom) throws InvalidDenominatorException{
		
		StringTokenizer st = new StringTokenizer(inHandDenom, ",");
		String token[] = new String[st.countTokens()];
		
		for(int i=0; i<st.countTokens(); i++){
			token[i] = st.nextToken();
		}
		
		Map<String, Integer> inHandDenomMap = new HashMap<String, Integer>();
		
		for(int i=0; i<token.length; i++){
			String stByDenom[] = token[i].split("\\*");
			
			if(stByDenom[0] == "PENNY"){
				availblePenny = new Integer(stByDenom[1]).intValue();
				inHandDenomMap.put("PENNY", availblePenny);
				break;
			} else if(stByDenom[0] == "NICKEL"){
				availableNickel = new Integer(stByDenom[1]).intValue();
				inHandDenomMap.put("NICKEL", availblePenny);				
				break;
			} else if(stByDenom[0] == "DIME"){
				availableDime = new Integer(stByDenom[1]).intValue();
				inHandDenomMap.put("DIME", availblePenny);				
				break;
			} else if(stByDenom[0] == "QUARTER"){
				availableQuarter = new Integer(stByDenom[1]).intValue();
				inHandDenomMap.put("QUARTER", availblePenny);				
				break;
			} else {
				System.out.println("Invaild Denom Token Name. Please ensure valid Denominator token name is providedn in input");
				throw new InvalidDenominatorException("Invaild Denom Token Name. Please ensure valid Denominator token name is providedn in input");
			}
		
		}
		
		return inHandDenomMap; 
		
	}
	
	public void getAvailableDenom(String inHandDenom){
		
		try {
			parseAvailableDenom(inHandDenom);
		} catch (InvalidDenominatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getChangeByDenomWithLimit(int cents, String inHandDenom){
		getAvailableDenom(inHandDenom);
	}
	

	public static void main(String args[]){
		ChangeMachineV11 change = new ChangeMachineV11();
		
		//change.getChangeByDenom(290);
		
		String inhand = "QUARTER*5,DIME*10,NICKEL*15,PENNY*4";
		change.getChangeByDenomWithLimit(477, inhand);
		
		
		
	}
	
}
