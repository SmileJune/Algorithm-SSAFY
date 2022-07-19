package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day163BOJ20040unionfind { // 20040 Union find
	static int N, M, ans;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		p = new int[N];
		for (int i = 0; i < N; i++)
			p[i] = i;

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!union(a, b)) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		br.close();
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		p[b] = a;
		return true;
	}

	private static int find(int n) {
		if (n == p[n])
			return n;
		return p[n] = find(p[n]);
	}
}