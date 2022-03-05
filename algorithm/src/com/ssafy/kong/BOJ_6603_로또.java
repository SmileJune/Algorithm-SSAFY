package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	static int N;
	static int[] arr;
	static boolean[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;
			arr = new int[N];
			result = new boolean[N];
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println();
		}
	}

	static void dfs(int s, int d) {
		if (d == 6) {
			for (int i = 0; i < N; i++) {
				if (result[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
		for (int i = s; i < N; i++) {
			result[i] = true;
			dfs(i + 1, d + 1);
			result[i] = false;
		}
	}
}