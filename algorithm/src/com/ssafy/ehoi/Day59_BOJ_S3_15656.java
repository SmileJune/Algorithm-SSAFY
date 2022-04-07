package com.ssafy.ehoi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Day59_BOJ_S3_15656 {
	// 중복 조합
	static int[] nums;
	static int[] sel;
	static int N, R;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		R = sc.nextInt();
		nums = new int[N];
		sel = new int[R];
		sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);

		perm(0, 0);
		bw.append(sb);
		bw.close();
//		System.out.println(sb);

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

		for (int i = start; i < N; i++) { // 조합이냐 순열이냐 
			sel[cnt] = nums[i];
//			perm(cnt + 1, i + 1);
			perm(cnt + 1, i); // 중복 담당
		}

	}
}
