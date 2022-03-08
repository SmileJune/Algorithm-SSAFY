package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_6485_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int max = 0;
			int[] nums = new int[N * 2]; // N쌍의 A, B (1 <= N <= 500)
			for (int i = 0; i < N; i++) {
				nums[i * 2] = sc.nextInt(); // A (1 <= A <= 5000)
				nums[i * 2 + 1] = sc.nextInt(); // B (A <= B <= 5000)
				max = Math.max(max, nums[i * 2 + 1]);
			}
			int[][] totalCnt = new int[N][5001];
			for (int i = 0; i < N; i++) {
				for (int j = nums[i * 2]; j <= nums[i * 2 + 1]; j++) {
					totalCnt[i][j]++; // i번째 노선의 j번째 정류장 하나씩 증가
				}
			}
			int P = sc.nextInt(); // (1 <= P <= 500)
			// int[] cNum = new int[P];
			// int[] station = new int[max+1];
			System.out.printf("#%d ", t);
			for (int i = 0; i < P; i++) {
				// cNum[i] = sc.nextInt();
				int C = sc.nextInt(); // (1 <= C <= 5000)
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					// cnt += totalCnt[j][cNum[i]];
					cnt += totalCnt[j][C];
				}
				// station[cNum[i]] = cnt;
				System.out.printf("%d ", cnt);
			}
			System.out.println();
		}
	}
}