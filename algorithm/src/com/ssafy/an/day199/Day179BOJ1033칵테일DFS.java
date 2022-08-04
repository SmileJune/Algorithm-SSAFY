package com.ssafy.an.day199;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day179BOJ1033칵테일DFS {

	static long[] D;
	static boolean[] visited;
	static ArrayList<int[]>[] al;
	static long lcm;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		D = new long[N];
		visited = new boolean[N];
		al = new ArrayList[N];
		lcm = 1;

		for (int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			al[a].add(new int[] { b, p, q });
			al[b].add(new int[] { a, q, p });

			lcm *= p * q / gcd(p, q);

		}

		D[0] = lcm;
		dfs(0);
		long mgcd = D[0];
		for (int i = 1; i < N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(D[i] / mgcd + " ");
		}

	}

	public static void dfs(int index) {

		visited[index] = true;
		for (int i = 0; i < al[index].size(); i++) {
			int next = al[index].get(i)[0];
			if (!visited[next]) {
				D[next] = D[index] * al[index].get(i)[2] / al[index].get(i)[1];
				dfs(next);
			}
		}

	}

	public static long gcd(long a, long b) {

		long max = a > b ? a : b;
		long min = a < b ? a : b;

		while (max % min != 0) {

			long temp = max;
			max = min;
			min = temp % min;

		}
		return min;
	}

}
