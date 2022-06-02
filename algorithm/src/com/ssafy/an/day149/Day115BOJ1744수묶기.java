package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day115BOJ1744수묶기 { // 1744 수 묶기
	static int N, ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr); // 두수의 곱의 최대값은 큰수끼리의 곱, 음수의 곱 처리, 정렬필요

		int idx = 0;
		while (idx < N - 1) // N - 2, N - 1 확인 시 인덱스 오류
			if (arr[idx] < 1 && arr[idx + 1] < 1)
				ans += arr[idx++] * arr[idx++]; // 둘다 음수면 곱, 하나 남아서 0이랑 짝이면 곱
			else break;

		int jdx = N - 1;
		while (jdx > 0)
			if (arr[jdx] > 1 && arr[jdx - 1] > 1)
				ans += arr[jdx--] * arr[jdx--];
			else break;

		while (idx <= jdx)
			ans += arr[idx++];

		System.out.println(ans);
		br.close();
	}
}
