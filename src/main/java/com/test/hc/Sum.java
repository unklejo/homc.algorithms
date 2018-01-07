package com.test.hc;

import java.util.Arrays;

public class Sum {
	public static void main(String[] args) {
		// initialize array
		int[] arr = { 1, 5, 2, -2 };

		System.out.println("Arr created: " + Arrays.toString(arr));

		// logic
		int ret = solution(arr);
		System.out.println("Sum: " + ret);
	}

	public static int solution(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0)
				sum += a[i] * -1;
			else
				sum += a[i];
		}
		return sum;
	}
}
