package santhosh.changemachine;

import static org.junit.Assert.*;

import org.junit.Test;

import com.santhosh.changemachine.ChangeMachine;
import com.santhosh.changemachine.ChangeMachineV11;
import com.santhosh.changemachine.InvalidDenominatorException;

public class ChangeMachineTest {


	@Test
	public void testChangeByDenom(){
		
		
		ChangeMachineV11 change = new ChangeMachineV11();
		
		try{
			change.getChangeByDenomWithLimit(227, "abc*1000");
		} catch(InvalidDenominatorException e){
			assertEquals("Invaild Denom Token Name. Please ensure valid Denominator token name is providedn in input", e.getMessage());
			e.printStackTrace();
		}
		

	}
}
