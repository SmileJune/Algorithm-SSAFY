package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day158BOJ1976서로소집합확인 {
	static int N, M, from, to;
	static int[] p = new int[201];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++)
			p[i] = i;

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				if (str.charAt(2 * (j - 1)) == '1')
					union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		boolean isPossible = true;

		if (st.hasMoreTokens())
			to = Integer.parseInt(st.nextToken());

		while (--M > 0) {
			from = to;
			to = Integer.parseInt(st.nextToken());

			if (find(from) != find(to)) {
				isPossible = false;
				break;
			}
		}

		System.out.println(isPossible ? "YES" : "NO");
	}

	static int find(int x) {
		if (x == p[x])
			return x;

		return p[x] = find(p[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;

		p[a] = p[b] = Math.min(a, b);
	}

}
