package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day39BOJ2606바이러스DFS재귀공부 { // 2606 바이러스 DFS공부
	static int[][] arr;
	static boolean[] check;
	static int cnt = -1; // 감염된 pc수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 컴퓨터 갯수
		int P = Integer.parseInt(br.readLine()); // 간선의 수

		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1][n2] = arr[n2][n1] = 1;
		}
		// 완전탐색을 하는 방법에 어울림. ex) 미로의 출구 찾기
		dfs(1);

		System.out.println(cnt);
		br.close();
	}

	private static void dfs(int idx) {
		if (check[idx])// 이미 감염된 PC라면 돌아가라.
			return;

		check[idx] = true;
		cnt++;

		for (int i = 0; i < arr[idx].length; i++) {
//			if (arr[idx][i] == 1 && !check[i]) { // return문이 있는데
			if (arr[idx][i] == 1) { // !check[i] 이 필요할까?? 없어도 된다.
				dfs(i);
			}
		}
	}
}
