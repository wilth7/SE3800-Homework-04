package test.java.com.companyname.calculator;

import org.junit.Before;
import org.junit.Test;

import main.java.com.application.calculator.Calculator;
import main.java.com.application.calculator.Operation;

/**
 * Created by ericmiller on 1/4/16.
 */
public class CalculatorTest {
	@Before
	public void setUp() throws Exception {
		Calculator.parseCommandAndRun("clear");
	}

	@Test
	public void testBadCommand() throws Exception {
		try {
			Calculator.parseCommandAndRun("notarealcommand");
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testAllWords() {
		try {
			Calculator.parseCommandAndRun("words are not numbers");
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testWordsForParameters() {
		try {
			Calculator.parseCommandAndRun("add 1 plus one");
		} catch (Exception e) {
			assert false;
		}
	}

	@Test
	public void testInvalidHistoryIndices() {
		try {
			Calculator.parseCommandAndRun("add !1000");
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testAdd() {
		try {
			Calculator.parseCommandAndRun("add 1 2 3 4");
			Operation op = Calculator.history.get(Calculator.history.size() - 1);
			System.out.println(op.getResult() + " == 10");
			assert op.getResult() == 10;
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testSub() {
		try {
			Calculator.parseCommandAndRun("sub 1 2 3 4");
			Operation op = Calculator.history.get(Calculator.history.size() - 1);
			System.out.println(op.getResult() + " == -8");
			assert op.getResult() == -8;
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testMul() {
		try {
			Calculator.parseCommandAndRun("mul -6 -7");
			Operation op = Calculator.history.get(Calculator.history.size() - 1);
			System.out.println(op.getResult() + " == 42");
			assert op.getResult() == 42;
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testDiv() {
		try {
			Calculator.parseCommandAndRun("div 120 7 2");
			Operation op = Calculator.history.get(Calculator.history.size() - 1);
			System.out.println(op.getResult() + " == 8");
			assert op.getResult() == 8;
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testFac() {
		try {
			Calculator.parseCommandAndRun("fac 8");
			Operation op = Calculator.history.get(Calculator.history.size() - 1);
			System.out.println(op.getResult() + " == 40320");
			assert op.getResult() == 40320;
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testHist() {
		try {
			Calculator.parseCommandAndRun("hist");

			Calculator.parseCommandAndRun("add 1 2 3");
			assert Calculator.history.size() == 1;

			Calculator.parseCommandAndRun("hist");
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testClear() {
		try {
			Calculator.parseCommandAndRun("add 1 2 3");
			assert Calculator.history.size() == 1;
			Calculator.parseCommandAndRun("sub 3 2 1");
			assert Calculator.history.size() == 2;

			Calculator.parseCommandAndRun("hist");
			assert Calculator.history.size() == 2;

			Calculator.parseCommandAndRun("clear");
			assert Calculator.history.size() == 0;
			Calculator.parseCommandAndRun("clear");
			assert Calculator.history.size() == 0;
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testUsingVariablesFromHistory() {
		try {
			testAdd();
			testSub();
			testMul();
			testDiv();
			Calculator.parseCommandAndRun("add !1 !2 !3 !4");
			assert Calculator.history.get(Calculator.history.size() - 1).getResult() ==
					Calculator.history.get(Calculator.history.size() - 2).getResult() +
							Calculator.history.get(Calculator.history.size() - 3).getResult() +
							Calculator.history.get(Calculator.history.size() - 4).getResult() +
							Calculator.history.get(Calculator.history.size() - 5).getResult();

		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}
}
