package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_3985_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] lenArr = new int[L+1];
		int[] exArr = new int[N+1];
		int[] rArr = new int[N+1];
		
		int max_ex = 0;
		int max_r = 0;
		
		for (int i = 1; i <= N; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			exArr[i] = k-p;
			for (int j = p; j <= k; j++) {
				if (lenArr[j] == 0)
					lenArr[j] = i;
			}
		}
		
		int max_len = 0;
		for (int i = 0; i <= N; i++) {
			if (max_len < exArr[i]) {
				max_len = exArr[i];
				max_ex = i;
			}
		}
		
		for (int i = 0; i <= L; i++) {
			if (lenArr[i] == 0)
				continue;
			rArr[lenArr[i]]++;
		}
		
		int max_cnt = 0;
		for (int i = 0; i <= N; i++) {
			if (max_cnt < rArr[i]) {
				max_cnt = rArr[i];
				max_r = i;
			}
		}
		
		System.out.println(max_ex);
		System.out.println(max_r);
	}
}
