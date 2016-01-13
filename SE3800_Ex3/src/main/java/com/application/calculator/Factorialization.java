package main.java.com.application.calculator;

/**
 * Created by ericmiller on 1/4/16.
 */
public final class Factorialization extends Operation {
	/**
	 * Creates an operation with a base and parameters.
	 *
	 * @param base   base number.
	 * @param params additional numbers to run operation with.
	 */
	public Factorialization(int base, int... params) {
		super(base, params);
		this.isResultCached = false;
	}

	@Override
	public int getResult() {
		// If it's not cached, we need to calculate it.
		int value = 1;
		if (!this.isResultCached) {
			for(int number = this.base; number > 1; number--) {
				value *= number;
			}
			this.result = value;
		}

		return this.result;
	}

	@Override
	public String getOperationName() {
		return "fac";
	}
}
