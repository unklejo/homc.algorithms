package com.test.hc;

import java.util.Arrays;
import java.util.Scanner;

public class CyclicRotationTest {
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
			
			// shift 
			System.out.print("Shifting Right: ");
			int shift = sc.nextInt();
			System.out.println();
			
			shift = shift % arrLength;
			if (shift > 0) {
				int[] newArr = new int[arrLength];
				for (int i = 0; i < arrLength; i++) {
					int newIdx = i + shift;
					if (newIdx > (arrLength - 1)) {
						newIdx = newIdx - arrLength;
					}
					newArr[newIdx] = oriArr[i];
				}
				System.out.println("New Array: " + Arrays.toString(newArr));
			} else {
				System.out.println("New Array: " + Arrays.toString(oriArr));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
