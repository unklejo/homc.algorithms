package com.test.hc;

import java.util.Arrays;

public class MissingInteger {
	public static void main(String[] args) {
		// initialize array
//		 int[] arr = { 1, 3, 6, 4, 1, 2 };
//		 int[] arr = { 1, 2, 3 };
//		 int[] arr = { -1, -3 };
		 int[] arr = {-1, -3, 6, 4, 1, 2 };

		System.out.println("Arr created: " + Arrays.toString(arr));

		// logic
		int ret = solution(arr);
		System.out.println("Smallest positive occur: " + ret);
	}

	public static int solution(int[] a) {
		int[] b = bubbleSort(a);
		if (b[b.length - 1] > 1) {
			int find = b[0];
			for (int i = 1; i < b.length; i++) {
				int gap = b[i] - b[i - 1];
				if (gap > 1 && b[i - 1] > 0) {
					find = b[i - 1] + 1;
					break;
				}
			}
			
			if (find == b[0]) {
				if (b[b.length - 1] > 0)
					return b[b.length - 1] + 1;
			} else {
				return find;
			}
		}
		return 1;
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
