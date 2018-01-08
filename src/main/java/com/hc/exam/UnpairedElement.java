package com.hc.exam;

import java.util.Arrays;

public class UnpairedElement {
	public static void main(String[] args) {
		int[] arr = {-3, 1, -3, 2, 9, 9, 2};
		int n = 7;

		System.out.println("Arr created: " + Arrays.toString(arr));

		// logic
		int ret = solution(arr, n);
		System.out.println("Unpaired element is: " + ret);
	}

	public static int solution(int[] a, int n) {
		int[] b = bubbleSort(a);
		for (int i = 1; i < b.length; i++) {
			if (i % 2 == 1) {
				if (b[i] != b[i-1])
					return b[i-1];
			} else {
				if (i == (b.length - 1))
					return b[i];
			}
			
		}
		return 0;
	}

	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
