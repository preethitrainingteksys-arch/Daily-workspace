package com.tek.day6.unitTesting;

import java.util.Arrays;

public class Math {

	int add(int a, int b) {
		return a + b;
	}

	int addwitharray(int[] numbers) {
		return Arrays.stream(numbers).reduce(0, (current, element) -> current + element);
	}

	int divide(int a, int b) {
		return a / b;
	}
}