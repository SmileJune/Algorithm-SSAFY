package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Day150BOJ3038완전이진트리 { // 3038 완전이진트리 구
	static int N;
	static StringBuilder sb;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dfs(1, 1, N);
		System.out.println(sb);
		br.close();
	}

	static void dfs(int c, int h, int n) {
		if (h == n) {
			sb.append(c).append(" ");
			return;
		}

		int s = (1 << n) - (1 << h) + 1;
		int l = (1 << (h - 1));
		sb.append(l - c + s).append(" ");

		dfs(c, h + 1, n);
		dfs(c + (1 << h - 1), h + 1, n);
	}

}
