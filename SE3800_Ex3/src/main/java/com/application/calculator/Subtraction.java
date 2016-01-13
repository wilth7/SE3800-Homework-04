package main.java.com.application.calculator;

/**
 * Created by ericmiller on 1/4/16.
 */
public class Subtraction extends Operation {

	public Subtraction(int base, int... params) {
		super(base, params);
		this.isResultCached = false;
	}

	@Override
	public int getResult() {
		// If it's not cached, we need to calculate it.
		if (!this.isResultCached) {
			int value = this.base;
			for (int number : parameters) {
				value -= number;
			}
			this.isResultCached = true;
			result = value;
		}

		return result;
	}

	@Override
	public String getOperationName() {
		return "sub";
	}
}
