package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day59BOJ11723집합비트마스킹구현 { // 11723 집합 비트마스킹 구현
	static int T = 0;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String act = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens())
				num = Integer.parseInt(st.nextToken());
			switch (act) {
			case "add":
				add(num);
				break;
			case "remove":
				remove(num);
				break;
			case "check":
				check(num);
				sb.append(check(num) ? 1 : 0).append("\n");
				break;
			case "toggle":
				toggle(num);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}

	private static int add(int n) {
		T = T | 1 << n;
		return T;
	}

	private static int remove(int n) {
		T -= T & 1 << n;
		return T;
	}

	private static boolean check(int n) {
		return (T & 1 << n) == (1 << n);
	}

	private static void toggle(int n) {
		T = check(n) ? remove(n) : add(n);
	}

	private static void all() {
		T = 2097150;
	}

	private static void empty() {
		T = 0;
	}
}
