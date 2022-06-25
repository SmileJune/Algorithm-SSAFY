package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day138BOJ1068트리DFS {
	static int N, rt, ans;
	static List<Integer>[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		rt = 0;
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++)
			arr[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p != -1)
				arr[p].add(i);
			else
				rt = i;
		}
		int c = Integer.parseInt(br.readLine());

		arr[c].clear();
		dfs(rt, c);

		if (rt == c)
			System.out.println(0);
		else if (c != 0 && ans == 0)
			System.out.println(1);
		else
			System.out.println(ans);
	}

	private static void dfs(int idx, int c) {
		if (idx == c)
			return;
		if (arr[idx].isEmpty() || (arr[idx].size() == 1 && arr[idx].get(0) == c))
			ans++;
		for (int n : arr[idx]) {
			if (n == c)
				continue;
			dfs(n, c);
		}
	}
}
