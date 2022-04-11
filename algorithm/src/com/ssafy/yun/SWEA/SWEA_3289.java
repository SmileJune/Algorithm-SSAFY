package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_3289 {
	static Scanner sc = new Scanner(System.in);
	static int[] data;
	static StringBuffer sb;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuffer();
			sb.append("#").append(tc).append(" ");
			solution();
			System.out.println(sb);
		}
	}

	private static void solution() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		data = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			data[i] = i;
		}
		for (int i = 0; i < m; i++) {
			if (sc.nextInt() == 1) {
				if (findSet(sc.nextInt()) == findSet(sc.nextInt())) {
					sb.append("1");
				} else {
					sb.append("0");
				}
				continue;
			}

			// 0일때
			union(sc.nextInt(), sc.nextInt());
		}
	}

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		data[py] = px;
	}

	private static int findSet(int x) {
		if (x == data[x])
			return x;
		return data[x] = findSet(data[x]);
	}
}
