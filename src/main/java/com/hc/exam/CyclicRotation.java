package com.hc.exam;

import java.util.Arrays;
import java.util.Scanner;

public class CyclicRotation {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			
			// initialize array
			System.out.print("Length: ");
			int arrLength = sc.nextInt();
			System.out.println();
			int[] a = new int[arrLength];
			for (int i = 0; i < arrLength; i++) {
				System.out.print("Add value: ");
				a[i] = sc.nextInt();
				System.out.println();
			}
			System.out.println("Array created: " + Arrays.toString(a));
			
			// shift 
			System.out.print("Shifting Right: ");
			int k = sc.nextInt();
			System.out.println();
			
			int[] ret = solution(a, k);
			System.out.println("New Array: " + Arrays.toString(ret));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
	
	public static int[] solution(int[] a, int k) {
		k = k % a.length;
		if (k > 0) {
			int[] newArr = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				int newIdx = i + k;
				if (newIdx > (a.length - 1)) {
					newIdx = newIdx - a.length;
				}
				newArr[newIdx] = a[i];
			}
			return newArr;
		}
		return a;
	}
}
