package com.test.hc;

import java.util.Arrays;

public class PoolFish {
	public static void main(String[] args) {
		// initialize array
		int[] fishArr = { 1, 2, 3, 4, 5 };
		int[] streamArr = { 0, 1, 0, 0, 0 };

		System.out.println("Array Fish created: " + Arrays.toString(fishArr));
		System.out.println("Array Stream created: "
				+ Arrays.toString(streamArr));

		// logic
		int ret = solution(fishArr, streamArr);
		System.out.println("Fish alive: " + ret);
	}

	public static int solution(int[] a, int[] b) {
		int dCount = 0; 
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 0)
				dCount++;
		}
		int uCount = b.length - dCount; 
		
		System.out.println("Down: " + dCount 
				+ ". Up: " + uCount);

		if (dCount > 0 && dCount < b.length) {
			int[] dArr = new int[dCount];
			int[] dSeqArr = new int[dCount];
			int[] uArr = new int[uCount];
			int[] uSeqArr = new int[uCount];
			int dIdx = 0;
			int uIdx = 0;
			for (int i = 0; i < a.length; i++) {
				if (b[i] == 0) {
					dArr[dIdx] = a[i];
					dSeqArr[dIdx] = i;
					dIdx++;
				} else {
					uArr[uIdx] = a[i];
					uSeqArr[uIdx] = i;
					uIdx++;
				}
			}
			
//			int i = 0, j = 0;
			int dAlive = dCount;
			int uAlive = uCount;
//			while (i < dCount) {
//				while (j < uCount) {
//					if (dSeqArr[i] > uSeqArr[j]) {
//						if (dArr[i] < uArr[j]) {
//							dCount--;
//						} else {
//							uCount--;
//						}
//					}
//					j++;
//				}
//				i++;
//			}
			
			
			
			for (int i = 0; i < dCount; i++) {
				for (int j = uCount - 1; j >= 0; j--) {
					if (uSeqArr[j] < dSeqArr[i]) {
						if (uArr[j] < dArr[i]) {
							uCount--;
							// the upstream fish is being eaten
							continue;
						}
					}
				}
			}
			
			return dAlive + uAlive;
		} else {
			return b.length;
		}
	}
}
