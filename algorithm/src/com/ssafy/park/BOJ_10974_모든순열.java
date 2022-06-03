package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {
	static int N;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];

		perm(0);
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			arr[cnt] = i + 1;
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}