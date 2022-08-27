package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day199BOJ1039교환 {
	public static int n, k, result = -1;
	public static char[] temp;
	public static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visit = new boolean[1000001][k + 1];

		temp = String.valueOf(n).toCharArray();

		visit[n][0] = true;

		dfs(0);

		System.out.println(result);

		br.close();
	}

	public static void dfs(int depth) {
		if (depth == k) {
			result = Math.max(Integer.parseInt(String.valueOf(temp)), result);
			return;
		}

		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				if (i == 0 && (temp[i] == '0' || temp[j] == '0'))
					continue;
				swap(i, j);
				if (!visit[Integer.parseInt(String.valueOf(temp))][depth + 1]) {
					visit[Integer.parseInt(String.valueOf(temp))][depth + 1] = true;
					dfs(depth + 1);
				}
				swap(i, j);
			}
		}
	}

	public static void swap(int a, int b) {
		char tempChar = temp[a];
		temp[a] = temp[b];
		temp[b] = tempChar;
	}
}
