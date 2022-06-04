package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day0604_ICOTE_DFS_01 {
	static int graph[][], n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 렬

		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		// 입력 끝
//		System.out.println(Arrays.deepToString(graph)); // 입력 확인 테스트
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) {
					dfs(i, j); // 0인거 1로 만들러 보내기
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int i, int j) {
		graph[i][j] = 1;

		// 4방 탐색해서 인접한 애 중에 0인애 1로 만들기
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			// 새로운 인덱스는 범위 안에 있을까?
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			if(graph[nr][nc] != 0) continue;
			
			// 0인 애만 다시 재귀로 들어가
			dfs(nr, nc);
		}
	}

}