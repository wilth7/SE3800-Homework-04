package test.java.com.companyname.calculator;

/**
 * Written by Wil Hoskins on 1/4/16
 **/

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.application.calculator.Factorialization;

public class FactorializationTest {
	@Test
public void testGetResult() {
	Factorialization f = new Factorialization(5);
	System.out.println(f.getResult());
	assert 120 == f.getResult();
	
	f = new Factorialization(5, 4, 3, 2, 1);
	System.out.println(f.getResult());
	assert 120 == f.getResult();
	
	f = new Factorialization(0);
	System.out.println(f.getResult());
	assert 1 == f.getResult();
	
	f = new Factorialization(-1);
	System.out.println(f.getResult());
	assert 1 == f.getResult();
	
	f = new Factorialization(1);
	System.out.println(f.getResult());
	assert 1 == f.getResult();
}

@Test
public void testGetOperationName() throws Exception{
	Factorialization f = new Factorialization(0);
	System.out.println(f.getOperationName());
	assert f.getOperationName().equals("fac");
}

@Test
public void testToString() throws Exception{
	Factorialization f = new Factorialization(5);
	System.out.println(new Factorialization(720, 6, 5, 4, 3, 2).toString());
	assert "fac 5 => 120".equals(f.toString());
	
	f = new Factorialization(5, 4, 3, 2, 1);
	System.out.println(f.toString());
	assert "fac 5 4 3 2 1 => 120".equals(f.toString());
	
	f = new Factorialization(0);
	System.out.println(f.toString());
	assert "fac 0 => 1".equals(f.toString());
	
	f = new Factorialization(-1);
	System.out.println(f.toString());
	assert "fac -1 => 1".equals(f.toString());
	
	f = new Factorialization(1);
	System.out.println(f.toString());
	assert "fac 1 => 1".equals(f.toString());
}
}
