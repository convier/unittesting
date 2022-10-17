package com.inl.tst;

public class Publisher {

	enum Operation {
		DIVIDE, SUM
	};

	public void publish(Operation operation, int value1, int value2, int result) {
		System.out.println(operation + " for: " + value1 + " and " + value2 + ", the result:" + result);
	}
}