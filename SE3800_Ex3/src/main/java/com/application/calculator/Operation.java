package main.java.com.application.calculator;

/**
 * Abstract parent class to support operations.
 */
public abstract class Operation {
	protected int base;
	protected int[] parameters;
	protected int result;
	protected boolean isResultCached;

	/**
	 * Creates an operation with a base and parameters.
	 *
	 * @param base   base number.
	 * @param params additional numbers to run operation with.
	 */
	public Operation(int base, int... params) {
		this.base = base;
		this.parameters = params;
	}

	/**
	 * Gets the result of the operation.
	 *
	 * @return the result
	 */
	public abstract int getResult();

	/**
	 * Gets the name of the operation
	 *
	 * @return the name
	 */
	public abstract String getOperationName();

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getOperationName());
		stringBuilder.append(" ");
		stringBuilder.append(base + " ");
		for (int number : parameters) {
			stringBuilder.append(number + " ");
		}
		stringBuilder.append("=> " + getResult());
		return stringBuilder.toString();
	}
}
