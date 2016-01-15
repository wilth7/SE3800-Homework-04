package main.java.com.application.calculator;

/**
 * Created by ericmiller on 1/4/16.
 */
public class Division extends Operation {
	public Division(int base, int... params) {
		super(base, params);
		this.isResultCached = false;
	}

	@Override
	public int getResult() {
		// If it's not cached, we need to calculate it.
		if (!this.isResultCached) {
			int value = this.base;
			for (int number : this.parameters) {
				if(number == 0) {
					value = 0;
					break;
				}
				value /= number;
			}
			this.isResultCached = true;
			this.result = value;
		}

		return this.result;
	}

	@Override
	public String getOperationName() {
		return "div";
	}
}
