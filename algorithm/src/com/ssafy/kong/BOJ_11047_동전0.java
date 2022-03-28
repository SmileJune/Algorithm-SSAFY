package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] money = new int[N];
		for (int i = 0; i < N; ++i) {
			money[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		for (int i = N - 1; i >= 0; --i) {
			while (K >= money[i] && K > 0) {
				K -= money[i];
				ans++;
			}
		}
		System.out.println(ans);
	}
}
