package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {
	static int N;
	static int[][] work;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		work = new int[N][2];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken()); // 걸리는 일수
			work[i][1] = Integer.parseInt(st.nextToken()); // 비용
		}
		recur(0, 0);
		System.out.println(ans);

	}

	static void recur(int day, int sum) {
		if (day >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		if (day + work[day][0] <= N) {
			recur(day + work[day][0], sum + work[day][1]);
		}
		recur(day + 1, sum);
	}
}