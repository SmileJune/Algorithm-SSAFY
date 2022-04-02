package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day53_BOJ_S1_2178 {
	static char[][] map;
	static int minLen;
	static int[][] visited;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			for (int j = 0; j < m; j++) {
				map[i] = tmp.toCharArray();
				visited[i][j] = -1;
			}
		}
		
		// 시작할 지점
		bfs(0, 0);
		System.out.println(visited[n-1][m-1]);

		sc.close();
	}

	// 상, 하, 좌, 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	

	public static void bfs(int x, int y) {
		Queue<Integer[]> q = new LinkedList<>();

		// 방문처리 먼저 해주고 큐에 삽입
		visited[x][y] = 1;
		q.add(new Integer[] {x, y});

		// 큐에 데이터가 있을 때만
		while (!q.isEmpty()) {
			// 하나를 뽑았는데
			Integer[] val = q.poll();
			// 거기 인덱스가 n과 m이라면 도착한 거지
			if(val[0] == n && val[1] == m) {
				return;
			}

			// 아니면 사방탐색을 해서
			for(int d = 0; d < 4; d++) {
				int nx = val[0] + dx[d];
				int ny = val[1] + dy[d];
				
				// 범위를 벗어났다면 
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				// 방문을 이미 했거나 벽이라면
				if(visited[nx][ny] != -1 || map[nx][ny] == '0') continue;
				// 여기서는 다음 통로 방문 가능한 아이
				// 방문처리도 해주고
				// minLen 갱신도 해야해
				visited[nx][ny] = visited[val[0]][val[1]] + 1;
				q.add(new Integer[] {nx, ny});
			}
		}
// 주성오빠 최고
	}
}
