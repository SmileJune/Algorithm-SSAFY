package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {
	static int N, K, answer;
	static int arr[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		visit = new boolean[N];
		answer = 0;
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		dfs(500, 0);
		System.out.println(answer);
	}

	static void dfs(int w, int day) {
		if (day == N) {
			answer++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			if (w - K + arr[i] >= 500) {
				dfs(w - K + arr[i], day + 1);
			}
			visit[i] = false;
		}
	}
}
