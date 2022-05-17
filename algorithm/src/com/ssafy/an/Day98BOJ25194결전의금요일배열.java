package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day98BOJ25194결전의금요일배열 { // 25194 결전의 금요일 배열복제
	static int N;
	static int[] arr;
	static boolean[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new boolean[7];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken()) % 7;

		ans[arr[0]] = true;
		for (int i = 1; i < N; i++) {
			if (ans[4]) break;
			boolean[] tmp = ans.clone();
			for (int n = 0; n < 7; n++) {
				if (!ans[n]) continue;
				tmp[(n + arr[i]) % 7] = true;
			}
			ans = tmp.clone();
			ans[arr[i]] = true;
		}

		System.out.println(ans[4] ? "YES" : "NO");
		br.close();
	}
}
