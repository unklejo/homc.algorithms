package com.test.hc;

import java.util.Scanner;

public class CountFactor {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			
			System.out.print("Input number: ");
			int n = sc.nextInt();
			System.out.println();
			
			System.out.println("Number of factors: " + solution(n));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static int solution(int n) {
		int tot = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				tot += 1;
			}
		}
		return tot;
	}
}
