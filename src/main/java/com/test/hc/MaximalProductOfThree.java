package com.test.hc;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalProductOfThree {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);

			// initialize array
			System.out.print("Length: ");
			int arrLength = sc.nextInt();
			System.out.println();
			int[] oriArr = new int[arrLength];
			for (int i = 0; i < arrLength; i++) {
				System.out.print("Add value: ");
				oriArr[i] = sc.nextInt();
				System.out.println();
			}
			System.out.println("Array created: " + Arrays.toString(oriArr));

			// check permutation
			int ret = solution(oriArr);
			System.out.println("Max product: " + ret);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static int solution(int[] a) {
		if (a.length > 0) {
			Integer[] maxThree = new Integer[] { Integer.MIN_VALUE,
					Integer.MIN_VALUE, Integer.MIN_VALUE };
			for (int i = 0; i < a.length; i++) {
				if (a[i] > maxThree[0]) {
					if (a[i] > maxThree[1]) {
						if (a[i] > maxThree[2]) {
							maxThree[0] = maxThree[1];
							maxThree[1] = maxThree[2];
							maxThree[2] = a[i];
							continue;
						}
						maxThree[0] = maxThree[1];
						maxThree[1] = a[i];
						continue;
					}
					maxThree[0] = a[i];
					continue;
				}
			}

			System.out.println(maxThree[0] + " | " + maxThree[1] + " | "
					+ maxThree[2]);

			return (maxThree[0] != Integer.MIN_VALUE ? maxThree[0] : 1)
					* (maxThree[1] != Integer.MIN_VALUE ? maxThree[1] : 1)
					* (maxThree[2] != Integer.MIN_VALUE ? maxThree[2] : 1);

		}
		return 0;
	}
}
