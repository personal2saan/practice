package com.santhosh.changemachine;

import java.util.HashMap;

import java.util.Map;

import java.util.StringTokenizer;

public class ChangeMachineNew { 

//Creating the ints of all of the coins 

int quarters;

int dimes; 

int nickles; 

int pennies; 

int avlQuarters; 

int avlDimes;

int avlNickles; 

int avlPennies; 

final int  RANGE=4; 

private void setDenomination (int cents) throws Exception { 

//The number  given by each of the coins is calculated 

quarters = (cents / 25); 

dimes = ((cents % 25) / 10); 

nickles = (((cents % 25) % 10) / 5); 

pennies = ((((cents % 25) % 10) % 5) / 1); 

if (avlQuarters > 0 && quarters > avlQuarters) { 

} 

if (avlDimes > 0 && dimes > avlDimes) { 

} 

if (avlNickles > 0 && nickles > avlNickles) { 

} 

if (avlPennies > 0 && dimes > avlPennies) { 

} 

} 

private void validateChange(int cents) throws Exception { 

if ((cents > 99) && (cents >0)) { 

} 

} 

private Map<String, String> parseChangeAvailable(String availableChange) { 

StringTokenizer st = new StringTokenizer(availableChange, ", "); 

Map<String, String> coins = new HashMap<String, String>(); 

String denomination; 

String[] coinDenom; 

while (st.hasMoreElements()) { 

} 

return coins; 

} 

private void setChangeAvailable(String availableChange) { 

Map<String, String> coins = parseChangeAvailable(availableChange); 

avlQuarters = Integer.parseInt((String) coins.get("quarters")); 

avlDimes = Integer.parseInt((String) coins.get("dimes"));; 

avlNickles = Integer.parseInt((String) coins.get("nickles")); 

avlPennies = Integer.parseInt((String) coins.get("pennies")); 

} 

public String getChange(int cents) throws Exception { 

validateChange(cents); 

setDenomination(cents); 

String change = quarters + " X " + "quarters " + dimes + " X " + "dimes " + nickles + " X " + 

"nickles " + pennies + " X " + "pennies "; 

return change; 

} 

public String getChangeBasedOnAvailablity(String availableChange, int cents) throws Exception { 

setChangeAvailable(availableChange); 

validateChange(cents); 

setDenomination(cents); 

String change = quarters + " X " + "quarters " + dimes + " X " + "dimes " + nickles + " X " + 

"nickles " + pennies + " X " + "pennies "; 

return change; 

}

public static void main(String args[]){
	
	ChangeMachineNew change = new ChangeMachineNew();
	
	try {
		change.getChange(235);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}