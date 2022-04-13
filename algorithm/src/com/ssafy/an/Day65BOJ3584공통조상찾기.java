package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day65BOJ3584공통조상찾기 {
	static int N, ans;
	static int[] p;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			p = new int[N + 1];
			visited = new boolean[N + 1];

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int par = Integer.parseInt(st.nextToken());
				p[Integer.parseInt(st.nextToken())] = par;
			}
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			dfs(n1);
			dfs(n2);

			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int n) {
		if (n == 0)
			return;
		if (visited[n]) {
			ans = n;
			return;
		}
		visited[n] = true;

		dfs(p[n]);
	}
}
