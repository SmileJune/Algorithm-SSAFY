package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day12_BOJ_2798B { // 2798
	static int ans, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		// idx, cnt, tmp
		blackJack(0, 0, 0);

		System.out.println(ans);
		br.close();
	}

	private static void blackJack(int idx, int cnt, int sum) { // 정수빈님 재귀
		if (cnt == 3 && sum <= M) { // cnt값으로 통제, 기본조건 확인
			ans = Math.abs(M - sum) < Math.abs(M - ans) ? sum : ans;
			return;
		}
		if (sum > M || idx == arr.length)
			return;

		blackJack(idx + 1, cnt, sum);
		blackJack(idx + 1, cnt + 1, sum + arr[idx]);
	}
}
