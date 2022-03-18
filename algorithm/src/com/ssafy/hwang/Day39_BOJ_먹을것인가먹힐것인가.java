package com.ssafy.hwang;

import java.util.Arrays;
import java.util.Scanner;

public class Day39_BOJ_먹을것인가먹힐것인가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {

			int cnt = 0;
			int[] A = new int[sc.nextInt()];
			int[] B = new int[sc.nextInt()];

			for (int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < B.length; i++) {
				B[i] = sc.nextInt();
			}
			Arrays.sort(A);
			Arrays.sort(B);
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B.length; j++) {
					if (A[i] > B[j]) {
						cnt++;
					} else {
						break;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}
}
