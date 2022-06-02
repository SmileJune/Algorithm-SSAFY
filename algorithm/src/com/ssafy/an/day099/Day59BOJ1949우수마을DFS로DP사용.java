package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day59BOJ1949우수마을DFS로DP사용 { // 1949 우수마을 선택 DFS로 DP 사용하는 기본적인 문제
	static int N;
	static int[] P;
	static List<Integer>[] list;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		P = new int[N + 1];
		list = new ArrayList[N + 1];
		dp = new int[N + 1][2];

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n < N + 1; n++) {
			P[n] = Integer.parseInt(st.nextToken());
		} // 0번 미사용

		for (int n = 0; n < N + 1; n++) {
			list[n] = new ArrayList<>();
		} // 0번 생성은 해도 연결된 노드 없어서 신경안써도 됨.

		for (int n = 0; n < N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			list[n1].add(n2);
			list[n2].add(n1);
		}

		dfs(1, 0);

		System.out.println(Math.max(dp[1][0], dp[1][1]));
		br.close(); // 최종적으로 처음 시작된 1번에서 선택하냐 마냐에 값이 중첩됨.
	}

	private static void dfs(int curr, int root) {
		for (int siv : list[curr]) {
			if (siv != root) { // 상단 노드로 회기하지 않도록
				dfs(siv, curr); // 현재를 상단으로 보는 하위 노드까지 내려감.
				dp[curr][1] += dp[siv][0];
				dp[curr][0] += Math.max(dp[siv][0], dp[siv][1]);
			} // 현재를 선택했으면, 인접한 siv는 미선택,
		} // 현재를 선택하지 않았으면, siv를 선택하냐, 마냐 중 큰 값
		dp[curr][1] += P[curr];
	} // 모든 노드 자신의 값을 선택한 칸에 기록, 리프노드부터 시작되는 부분
}
