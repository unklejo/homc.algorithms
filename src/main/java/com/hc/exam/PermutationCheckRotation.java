package com.hc.exam;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationCheckRotation {
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
			System.out.println("Is array permutation: " + ret);
			
			
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
			// assigning to temp
			int[] tempArr = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				if (a[i] > a.length || a[i] < 1) {
					return 0;
				} else {
					tempArr[a[i] - 1] = a[i];
				}
			}
			
			// checking temp array
			for (int i = 0; i < tempArr.length; i++) {
				if (tempArr[i] == 0) {
					return 0;
				}
			}
			return 1;
		}
		return 0;
	}
}
