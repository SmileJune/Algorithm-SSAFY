package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Day128BOJ2213트리독립집합 {
	static int[] arr;
	static Integer[][] dp;
	static List<Integer>[] edges;
	static List<Integer> path;
	static boolean[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new Integer[2][n + 1];
		path = new ArrayList<>();
		selected = new boolean[n + 1];
		edges = new List[n + 1];
		for (int i = 1; i <= n; i++)
			edges[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 0, a, b; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}

		int root = getAnyRoot();
		sb.append(getDP(0, root, -1)).append("\n");

		findPath(root, -1, false);
		Collections.sort(path);
		for (Integer route : path) {
			sb.append(route).append(" ");
		}
		System.out.println(sb);
		br.close();
	}

	private static void findPath(int cur, int parent, boolean disabled) {
		if (selected[cur] && !disabled) {
			path.add(cur);
			disabled = true;
		} else {
			disabled = false;
		}
		for (Integer child : edges[cur]) {
			if (child == parent) {
				continue;
			}
			findPath(child, cur, disabled);
		}
	}

	private static int getAnyRoot() {
		for (int i = 1; i < edges.length; i++) {
			if (edges[i].size() == 1) {
				return i;
			}
		}
		return 1;
	}

	private static int getDP(int parentCon, int cur, int parent) {
		if (dp[parentCon][cur] != null) {
			return dp[parentCon][cur];
		}
		int ret = 0;
		if (parentCon == 0) {
			int contCase = arr[cur];
			int noneCase = 0;
			for (int child : edges[cur]) {
				if (child == parent) {
					continue;
				}
				contCase += getDP(1, child, cur);
				noneCase += getDP(0, child, cur);
			}
			if (contCase > noneCase) {
				selected[cur] = true;
				ret = contCase;
			} else {
				ret = noneCase;
			}
		} else {
			for (int child : edges[cur]) {
				if (child == parent) {
					continue;
				}
				ret += getDP(0, child, cur);
			}
		}
		return dp[parentCon][cur] = ret;
	}
}
