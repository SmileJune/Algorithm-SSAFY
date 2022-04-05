package com.ssafy.ehoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day57_BOJ_S2_2961 {
	// 부분집합 - 재귀 호출
	static int N;
	static int[][] arr;
	static int[][] sel;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		sel = new int[11][2];

		// 재료 정보 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		min = Integer.MAX_VALUE;
		// 부분집합 고고
		powerset(0, 0);
		System.out.println(min);

		sc.close();
	}

	private static void powerset(int cnt, int start) {
		if (start == N) {
			if (cnt == 0) return;
				int S = 1;
				int B = 0;
				for (int i = 0; i < cnt; i++) {
					// 신맛은 다 곱해
					S *= sel[i][0];
					// 쓴맛은 다 더해
					B += sel[i][1];
				}
//				System.out.println(S);
//				System.out.println(B);
				// 차이를 구해
				int val = Math.abs(S - B);
				// 여기서 비교하고
				min = Math.min(val, min);

			return;
		}

		sel[cnt] = arr[start];
		// 뽑고 가고
		powerset(cnt + 1, start + 1);
		// 안 뽑고 가고
		powerset(cnt, start + 1);
	}
}
