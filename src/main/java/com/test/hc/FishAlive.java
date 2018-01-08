package com.test.hc;

import java.util.Arrays;

public class FishAlive {
	public static void main(String[] args) {
		// initialize array
		int[] fishArr = { 4, 3, 2, 1, 5 };
		int[] streamArr = { 0, 1, 0, 0, 0 };

		System.out.println("Array Fish created: " + Arrays.toString(fishArr));
		System.out.println("Array Stream created: "
				+ Arrays.toString(streamArr));

		// logic
		int ret = solution(fishArr, streamArr);
		System.out.println("Fish alive: " + ret);
	}

	public static int solution(int[] a, int[] b) {
		int uCount = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 1)
				uCount++;
		}
		System.out.println("Up: " + uCount + ". Down: " + (b.length - uCount));

		// check flow varieties
		if (uCount > 0 && uCount < b.length) {
			int[] uArr = new int[uCount];
			int uDeadCount = 0;
			int dDeadCount = 0;

			// use stack, where 0 is the most front elmt
			// note: up = go to right
			// note: down = go to left
			for (int i = 0; i < a.length; i++) {
				if (b[i] == 0) {
					// go to downstream
					for (int m = 0; m < uArr.length; m++) {
						if (uArr[0] > 0) {
							if (uArr[0] < a[i]) {
								// upstream fish being eaten
								uDeadCount++;
								uArr = pop(uArr);
							} else {
								// downstream fish being eaten
								dDeadCount++;
								break;
							}
						} else {
							// no more upstream fish
							break;
						}
					}
				} else {
					// go with the down stream
					uArr = push(uArr, a[i]);
				}
			}

			return a.length - dDeadCount - uDeadCount;
		}

		// all alive
		return a.length;
	}

	private static int[] push(int[] arr, int a) {
		if (arr[arr.length - 1] == 0) {
			// first check whether array empty / not
			if (arr[0] == 0) {
				arr[0] = a;
			} else {
				for (int i = arr.length - 1; i > 0; i--) {
					if (arr[i - 1] == 0)
						continue;
					else {
						arr[i] = arr[i - 1];
						if (i > 1)
							arr[i - 1] = 0;
						else
							arr[i - 1] = a;
					}
				}
			}
		}
		return arr;
	}

	private static int[] pop(int[] arr) {
		if (arr[0] > 0) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] != 0)
					arr[i] = arr[i + 1];
				else
					break;
			}
		}
		return arr;
	}

}
