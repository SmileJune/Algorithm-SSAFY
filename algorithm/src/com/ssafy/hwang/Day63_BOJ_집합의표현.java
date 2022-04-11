package com.ssafy.hwang;

import java.util.Scanner;

public class Day63_BOJ_집합의표현 {
	static int[] data;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int V = sc.nextInt();
		int E = sc.nextInt();
		data = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			makeSet(i);
		}
		for (int i = 0; i < E; i++) {
			int sel = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			switch (sel) {
			case 1:
				check(x, y);
				break;
			case 0:
				union(x, y);
				break;
			}

		}
		System.out.println(sb);
	}

	private static void check(int x, int y) {
		if (findSet(x) == findSet(y)) {
			sb.append("YES\n");
			return;
		}
		sb.append("NO\n");
	}

	private static void union(int x, int y) {
		data[findSet(y)] = findSet(x);
	}

	private static int findSet(int x) {
		if (x == data[x])
			return x;
		return data[x] = findSet(data[x]);
	}

	private static void makeSet(int x) {
		data[x] = x;
	}
}