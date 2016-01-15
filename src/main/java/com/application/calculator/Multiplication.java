package main.java.com.application.calculator;

/**
 * Written by Wil Hoskins on 1/3/2016
 **/
public class Multiplication extends Operation {
	//constructor, uses constructor for Operation
	public Multiplication(int base, int... params) {
		super(base, params);
		this.isResultCached = false;
	}
	
	//returns the result (product) of the operation
	@Override
	public int getResult(){
		if (!this.isResultCached) {
			int value = this.base;
			for (int number : parameters) {
				value *= number;
			}
			this.isResultCached = true;
			result = value;
		}
		return result;
	}

	//returns the name (mul) of the operation
	@Override
	public String getOperationName() {
		return "mul";
	}
}
