package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day59_BOJ_S3_15655 {
	// 조합 (중복해서 뽑지 않음)
	static int[] nums;
	static int[] sel;
	static int N, R;
//	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		N = sc.nextInt();
		R = sc.nextInt();
		nums = new int[N];
		sel = new int[R];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);

//		System.out.println(Arrays.toString(nums));

		// 0부터 뽑아조요
		perm(0, 0);
		System.out.println(sb);
		sc.close();
	}

	private static void perm(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}

		// 조합
		for(int i = start; i < N; i++) {
			sel[cnt] = nums[i];
			perm(cnt + 1, i + 1);
		}
		
		
	}
}
