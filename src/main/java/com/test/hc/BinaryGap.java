package com.test.hc;

import java.util.Scanner;

public class BinaryGap {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			
			System.out.print("Input number: ");
			int n = sc.nextInt();
			System.out.println();
			
			System.out.println("Number of gaps: " + solution(n));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static int solution(int n) {
		String x = Integer.toBinaryString(n);
		System.out.println("Binary: " + x);
		char[] charArr = x.toCharArray();
		int longestGap = 0;
		int countGap = 0;
		boolean counting = false;
		for (int i = 1; i < charArr.length - 1; i++) {
			if (charArr[i-1] == '0' && charArr[i] == '0') {
				if (counting)
					countGap++;
			} else if (charArr[i-1] == '0' && charArr[i] == '1') {
				// closing
				if (counting) {
					countGap++;
					if (countGap > longestGap) {
						longestGap = countGap;
					}
				}
			} else if (charArr[i-1] == '1') {
				counting = true;
				countGap = 0;
			}
		}
		
		return longestGap;
	}
}
