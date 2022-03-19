package com.ssafy.namja;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_7795_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				B[i] = sc.nextInt();
			Arrays.sort(A);
			Arrays.sort(B);
			
			int cnt = 0;
			for (int i : A) {
				for (int j : B) {
					if (i > j)
						cnt++;
					else
						break;
				}
			}
			System.out.println(cnt);
		}
	}
}