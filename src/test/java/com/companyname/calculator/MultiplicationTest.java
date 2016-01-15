package test.java.com.companyname.calculator;

import org.junit.Test;

import main.java.com.application.calculator.Multiplication;

/**
 * Created by ericmiller on 1/4/16.
 */
public class MultiplicationTest {

	@Test
	public void testGetResult() throws Exception {
		Multiplication multiply = new Multiplication(5, 7, 500, -77, 0);
		System.out.println(new Multiplication(5, 7, 500, -77, 0).toString());
		assert "mul 5 7 500 -77 0 => 0".equals(multiply.toString());

		multiply = new Multiplication(0, 0, 0, 0);
		System.out.println(multiply.toString());
		assert "mul 0 0 0 0 => 0".equals(multiply.toString());

		multiply = new Multiplication(12);
		System.out.println(multiply.toString());
		assert "mul 12 => 12".equals(multiply.toString());

		multiply = new Multiplication(-10, -10, -20);
		System.out.println(multiply.toString());
		assert "mul -10 -10 -20 => -2000".equals(multiply.toString());

		multiply = new Multiplication(1, 2, 3, -6);
		System.out.println(multiply.toString());
		assert "mul 1 2 3 -6 => -36".equals(multiply.toString());

		multiply = new Multiplication(0);
		System.out.println(multiply.toString());
		assert "mul 0 => 0".equals(multiply.toString());

	}

	@Test
	public void testOperationName() throws Exception{
		Multiplication multiply = new Multiplication(0);
		System.out.println(multiply.getOperationName());
		assert multiply.getOperationName().equals("mul");

	}

	@Test
	public void testToString() throws Exception {
		Multiplication multiply = new Multiplication(5, 7, 500, -77, 0);
		System.out.println(new Multiplication(5, 7, 500, -77, 0).getResult());
		assert 0 == (multiply.getResult());

		multiply = new Multiplication(0, 0, 0, 0);
		System.out.println(multiply.getResult());
		assert 0 == (multiply.getResult());

		multiply = new Multiplication(12);
		System.out.println(multiply.getResult());
		assert 12 == (multiply.getResult());

		multiply = new Multiplication(-10, -10, -20);
		System.out.println(multiply.getResult());
		assert -2000 == (multiply.getResult());

		multiply = new Multiplication(1, 2, 3, -6);
		System.out.println(multiply.getResult());
		assert -36 == (multiply.getResult());

		multiply = new Multiplication(0);
		System.out.println(multiply.getResult());
		assert 0 == (multiply.getResult());
	}
}
