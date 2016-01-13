package test.java.com.companyname.calculator;

import org.junit.Test;

import main.java.com.application.calculator.Addition;

/**
 * Created by ericmiller on 1/4/16.
 */
public class AdditionTest {
	@Test
	public void testGetResult() throws Exception {
		Addition addition = new Addition(5, 7, 500, -77, 0);
		System.out.println(addition.getResult());
		assert 435 == addition.getResult();

		addition = new Addition(0, 0, 0, 0);
		System.out.println(addition.getResult());
		assert 0 == addition.getResult();

		addition = new Addition(12);
		System.out.println(addition.getResult());
		assert 12 == addition.getResult();

		addition = new Addition(-10, -10, -20);
		System.out.println(addition.getResult());
		assert -40 == addition.getResult();

		addition = new Addition(1, 2, 3, -6);
		System.out.println(addition.getResult());
		assert 0 == addition.getResult();

		addition = new Addition(0);
		System.out.println(addition.getResult());
		assert 0 == addition.getResult();

		addition = new Addition(1, 2, 3);
		System.out.println(addition.getResult());
		assert 6 == addition.getResult();
	}

	@Test
	public void testGetOperationName() throws Exception {
		Addition addition = new Addition(0);
		System.out.println(addition.getOperationName());
		assert addition.getOperationName().equals("add");
	}

	@Test
	public void testToString() throws Exception {
		Addition addition = new Addition(5, 7, 500, -77, 0);
		System.out.println(new Addition(5, 7, 500, -77, 0).toString());
		assert "add 5 7 500 -77 0 => 435".equals(addition.toString());

		addition = new Addition(0, 0, 0, 0);
		System.out.println(addition.toString());
		assert "add 0 0 0 0 => 0".equals(addition.toString());

		addition = new Addition(12);
		System.out.println(addition.toString());
		assert "add 12 => 12".equals(addition.toString());

		addition = new Addition(-10, -10, -20);
		System.out.println(addition.toString());
		assert "add -10 -10 -20 => -40".equals(addition.toString());

		addition = new Addition(1, 2, 3, -6);
		System.out.println(addition.toString());
		assert "add 1 2 3 -6 => 0".equals(addition.toString());

		addition = new Addition(0);
		System.out.println(addition.toString());
		assert "add 0 => 0".equals(addition.toString());

		addition = new Addition(1, 2, 3);
		System.out.println(addition.getResult());
		assert "add 1 2 3 => 6".equals(addition.toString());
	}
}
