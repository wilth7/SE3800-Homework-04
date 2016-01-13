package test.java.com.companyname.calculator;

/**
 * Written by Wil Hoskins on 1/4/16
 **/

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.application.calculator.Division;

public class DivisionTest {
	@Test
	public void testGetResult() {
		Division d = new Division(720, 6, 5, 4, 3, 2);
		System.out.println(d.getResult());
		assert 1 == d.getResult();
		
		d = new Division(1, 2, 3, 4);
		System.out.println(d.getResult());
		assert 0 == d.getResult();
		
		d = new Division(1, 2, 3, 0);
		System.out.println(d.getResult());
		assert 0 == d.getResult();
		
		d = new Division(0, 0);
		System.out.println(d.getResult());
		assert 0 == d.getResult();
		
		d = new Division(0, 1, 2);
		System.out.println(d.getResult());
		assert 0 == d.getResult();
	}
	
	@Test
	public void testGetOperationName() throws Exception{
		Division d = new Division(0);
		System.out.println(d.getOperationName());
		assert d.getOperationName().equals("div");
	}
	
	@Test
	public void testToString() throws Exception{
		Division d = new Division(720, 6, 5, 4, 3, 2);
		System.out.println(new Division(720, 6, 5, 4, 3, 2).toString());
		assert "div 720 6 5 4 3 2 => 1".equals(d.toString());
		
		d = new Division(1, 2, 3, 4);
		System.out.println(d.toString());
		assert "div 1 2 3 4 => 0".equals(d.toString());
		
		d = new Division(1, 2, 3, 0);
		System.out.println(d.toString());
		assert "div 1 2 3 0 => 0".equals(d.toString());
		
		d = new Division(0, 0);
		System.out.println(d.toString());
		assert "div 0 0 => 0".equals(d.toString());
		
		d = new Division(0, 1, 2);
		System.out.println(d.toString());
		assert "div 0 1 2 => 0".equals(d.toString());
	}
}