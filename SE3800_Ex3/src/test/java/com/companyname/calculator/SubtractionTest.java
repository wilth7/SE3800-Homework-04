package test.java.com.companyname.calculator;

/**
 * Written by Wil Hoskins on 1/4/16
 **/

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.application.calculator.Subtraction;

public class SubtractionTest {

	@Test
	public void testGetResult() {
		Subtraction s = new Subtraction(100, 22, -33, 4, 5);
		System.out.println(s.getResult());
		assert 102 == s.getResult();
		
		s = new Subtraction(0, 0, 0);
		System.out.println(s.getResult());
		assert 0 == s.getResult();
		
		s = new Subtraction(58008);
		System.out.println(s.getResult());
		assert 58008 == s.getResult();
		
		s = new Subtraction(10, 11, -1);
		System.out.println(s.getResult());
		assert 0 == s.getResult();
		
		s = new Subtraction(7, 8, 9);
		System.out.println(s.getResult());
		assert -10 == s.getResult();
	}
	
	@Test
	public void testGetOperationName() throws Exception{
		Subtraction s = new Subtraction(0);
		System.out.println(s.getOperationName());
		assert s.getOperationName().equals("sub");
	}
	
	@Test
	public void testToString() throws Exception{
		Subtraction s = new Subtraction(100, 22, -33, 4, 5);
		System.out.println(new Subtraction(100, 22, -33, 4, 5).toString());
		assert "sub 100 22 -33 4 5 => 102".equals(s.toString());
		
		s = new Subtraction(0, 0, 0);
		System.out.println(s.toString());
		assert "sub 0 0 0 => 0".equals(s.toString());
		
		s = new Subtraction(58008);
		System.out.println(s.toString());
		assert "sub 58008 => 58008".equals(s.toString());
		
		s = new Subtraction(10, 11, -1);
		System.out.println(s.toString());
		assert "sub 10 11 -1 => 0".equals(s.toString());
		
		s = new Subtraction(7, 8, 9);
		System.out.println(s.toString());
		assert "sub 7 8 9 => -10".equals(s.toString());
	}

}
