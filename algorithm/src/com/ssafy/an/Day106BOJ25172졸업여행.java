package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day106BOJ25172졸업여행 { // 25172 졸업여행
	static int N, M, cnt;
	static int[] p, ers;
	static boolean[] ans, ext;
	static List<Integer>[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;

		p = new int[N];
		ers = new int[N];

		ans = new boolean[N + 1];
		ext = new boolean[N];

		edges = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			p[i] = i;
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			edges[a].add(b);
			edges[b].add(a);
		}

		for (int i = 0; i < N; i++)
			ers[i] = Integer.parseInt(br.readLine()) - 1;
		ans[N] = false;
		for (int i = N - 1; i >= 0; i--) {
			int n = ers[i];
			ext[n] = true;
			cnt++;
			for (int c : edges[n]) {
				if (!ext[c])
					continue;
				if (unionSet(n, c))
					cnt--;
			}
			if (cnt == 1)
				ans[i] = true;
		}

		for (int i = 0; i < N + 1; i++)
			sb.append(ans[i] ? "CONNECT" : "DISCONNECT").append("\n");

		System.out.println(sb);
		br.close();
	}

	private static boolean unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if (a == b)
			return false;
		p[b] = a;
		return true;
	}

	private static int findSet(int a) {
		return p[a] = (a == p[a]) ? a : findSet(p[a]);
	}
}
