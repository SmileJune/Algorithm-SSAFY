package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_7964_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] city = new int[N];
			for (int i = 0; i < N; i++)
				city[i] = sc.nextInt();
			
			int total = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (city[i] == 0)
					cnt++;
				else cnt = 0;
				if (cnt == D) {
					total++;
					cnt = 0;
				}
			}
			System.out.printf("#%d %d\n",t,total);
		}
	}
}