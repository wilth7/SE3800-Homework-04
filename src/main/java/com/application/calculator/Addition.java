package main.java.com.application.calculator;

/**
 * Written by Wil Hoskins on 1/3/2016
 **/
public class Addition extends Operation {
	//constructor, uses constructor for Operation
	public Addition(int base, int... params) {
		super(base, params);
		this.isResultCached = false;
	}
	 
	//returns the result (sum) of the operation
	@Override
	public int getResult(){
		if (!this.isResultCached) {
			int value = this.base;
			for (int number : parameters) {
				value += number;
			}
			this.isResultCached = true;
			result = value;
		}
		return result;
	}

	//returns the name (add) of the operation
	@Override
	public String getOperationName() {
		return "add";
	}
}
