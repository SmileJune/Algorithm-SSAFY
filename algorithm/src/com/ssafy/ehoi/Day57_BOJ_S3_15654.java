package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day57_BOJ_S3_15654 {
	// 순열 (중복해서 뽑지 않음)
	// 미리 정렬해놓고 순열 뽑기
	static int[] nums;
	static int[] sel;
	static int N, R;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		N = sc.nextInt();
		R = sc.nextInt();
		nums = new int[N];
		sel = new int[R];
		visited = new boolean[N];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);

//		System.out.println(Arrays.toString(nums));

		// 0부터 뽑아조요
		perm(0);
		System.out.println(sb);
		sc.close();
	}

	private static void perm(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			sel[cnt] = nums[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}

	}
}
