package com.santhosh.changemachine;

import java.util.StringTokenizer;

public class ChangeSumMachine {

	private static String COMMA = "\\,";
	private static String MULTIPLY = "\\*";
	
	private void calculateSumFromChange(String[] input){
	
		String stringValuesToMultiply[] = new String[input.length];
		int sumOfChange = 0;
		
		for(int i=0; i<input.length; i++){
			System.out.println("Going to split by Multiply Delimiter");
			stringValuesToMultiply = tokenizeStringByDelim(input[i],MULTIPLY);
			int intValuesToMultiply[] = convertToInt(stringValuesToMultiply);
			sumOfChange = sumOfChange + (intValuesToMultiply[0] * intValuesToMultiply[1]); 
		}
		
		System.out.println("Total Change is "+sumOfChange);
		
		
	}
	
	private String[] tokenizeStringByDelim(String input, Object delim){
		System.out.println("Delim type here is "+delim.toString());
		StringTokenizer st = new StringTokenizer(input, delim.toString());
		String tokenizedOutput[] = new String[input.split(delim.toString()).length];
		for(int i=0; st.hasMoreTokens(); i++){
			tokenizedOutput[i] = st.nextToken();
		}
		return tokenizedOutput;
	}
	
/*	private String[] tokenizeStringByMul(String input, Object delim){
		StringTokenizer st = new StringTokenizer(input, delim.toString());
		String tokenizedOutput[] = new String[input.split(delim.toString()).length];
		for(int i=0; st.hasMoreTokens(); i++){
			tokenizedOutput[i] = st.nextToken();
		}
		return tokenizedOutput;
	}*/
	
	private int[] convertToInt(String[] input){
		int output[] = new int[2];
		for(int i=0; i<input.length; i++){
			output[i] = new Integer(input[i]);
		}
		return output;
	}
	
	

	public static void main (String args[]){
		
		ChangeSumMachine changeMachine = new ChangeSumMachine();
		String inputChange = null;
		
		if(args!=null){
			try{
				inputChange = args[0];
			}
			catch(ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
				System.out.println("Invalid Input, Either the input is empty or the used in array is more than the input index");
			}
		}
		else{
			System.out.println("Input Empty, please provide a valid input");
		}
		
		System.out.println("Going to split by Comma Delimiter");
		String[] tokenizedStrings = changeMachine.tokenizeStringByDelim(inputChange,ChangeSumMachine.COMMA);
		
		System.out.println("tokenizedSteings length "+tokenizedStrings.length);
		
		for(int i=0; i<tokenizedStrings.length; i++){
			System.out.println("Strig Number "+i+" with text "+tokenizedStrings[i]);
		}	
		
		changeMachine.calculateSumFromChange(tokenizedStrings);
	}
}

