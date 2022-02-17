package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5215 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	static int N, limit, scoreMax, calSum, totalScore;
	static int[] scoreArr, cal;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			scoreMax = 0;
			calSum = 0;
			totalScore = 0;
			scoreArr = new int[N];
			cal = new int[N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scoreArr[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			powerset(0);
			System.out.printf("#%d %d%n", tc, scoreMax);
		}
	}

	static void powerset(int idx) {
		if (idx == N) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					calSum += cal[i];
				}
			}
			if (calSum <= limit) {
				for (int i = 0; i < scoreArr.length; i++) {
					if (visited[i]) {
						totalScore += scoreArr[i];
					}
				}
				scoreMax = Math.max(scoreMax, totalScore);
			}
			calSum = 0;
			totalScore = 0;
			return;
		}

		visited[idx] = true;
		powerset(idx + 1);

		visited[idx] = false;
		powerset(idx + 1);
	}

}
