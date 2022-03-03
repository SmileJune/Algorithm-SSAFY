package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, K, cnt;
	public static boolean[] visited;
	public static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws IOException {
		cnt = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		visited = new boolean[N];
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		powerset(0);

		return cnt;
	}

	public static void powerset(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			if (sum == K) {
				cnt++;
			}
			return;
		}

		visited[idx] = true;
		powerset(idx + 1);

		visited[idx] = false;
		powerset(idx + 1);

	}

}
