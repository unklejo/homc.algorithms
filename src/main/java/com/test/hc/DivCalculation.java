package com.test.hc;

import java.util.Scanner;

public class DivCalculation {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			
			System.out.print("A: ");
			int a = sc.nextInt();
			System.out.println();
			
			System.out.print("B: ");
			int b = sc.nextInt();
			System.out.println();

			System.out.print("K: ");
			int k = sc.nextInt();
			System.out.println();
			
			// check permutation
			int ret = solution(a, b, k);
			System.out.println("Number that can be divided: " + ret);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
	
	public static int solution(int a, int b, int k) {
		if (a < b) {
			int c = 0;
			for (int i = a; i <= b; i++) {
				if (i % k == 0) {
					c++;
				}
			}
			return c;
		}
		return 0;
	}
}
