package com.inl.tst;

import com.inl.tst.Publisher.Operation;

public class CalculatorImpl implements Calculator {

	private Publisher publisher;

	public CalculatorImpl() {
		this(new Publisher());
	}
	
	 CalculatorImpl(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public int devide(int value1, int value2) {
		int result = value1 / value2;
		publisher.publish(Operation.DIVIDE, value1, value2, result);
		return result;
	}

	@Override
	public int sum(int value1, int value2) {
		int result = value1 + value2;		
		publisher.publish(Operation.SUM, value1, value2, result);
		return result;
	}
}