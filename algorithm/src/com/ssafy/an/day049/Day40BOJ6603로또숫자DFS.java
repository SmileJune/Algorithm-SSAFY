package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day40BOJ6603로또숫자DFS { // 3306 로또 재귀 dfs
	static int N;
	static int[] arr;
	static boolean[] chk;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		while (true) {
			String tmp = br.readLine();
			if (tmp.equals("0"))
				break;
			st = new StringTokenizer(tmp);
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			chk = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int st, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < N; i++) {
				if (chk[i])
					sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		for (int i = st; i < N; i++) {
			chk[i] = true;
			dfs(i + 1, cnt + 1);
			chk[i] = false;
		}
	}
}
