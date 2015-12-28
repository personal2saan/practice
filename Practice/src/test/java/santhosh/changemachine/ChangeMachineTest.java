package santhosh.changemachine;

import static org.junit.Assert.*;

import org.junit.Test;

import com.santhosh.changemachine.ChangeMachine;

public class ChangeMachineTest {

	
	ChangeMachine tester = new ChangeMachine();

	
	@Test
	public void testStringToDoubleConversionNumberStringInput() {
		
		assertEquals(10.25, tester.convertStringToDouble("10.25"), 0);
		
	}
	
	@Test
	public void testStringToDoubleConversionAlphabetStringInput(){
		assertArrayEquals(new NullPointerException(), tester.convertStringToDouble("Santhosh"));
	}

}
