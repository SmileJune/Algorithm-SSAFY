package com.ssafy.ehoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day0604_ICOTE_DFS_02 {
	static int n, m, graph[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
//			System.out.println(str);
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		} // 입력 끝
//		System.out.println(Arrays.deepToString(graph));

		// 시작 포인트로 입장
		bfs(0, 0);

		// 종료 포인트의 값 출력
		System.out.println(graph[n - 1][m - 1]);

		sc.close();
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs(int i, int j) {
		// bfs는 일단 큐부터 생성
		Queue<Node> q = new LinkedList<>();
		// 들어온 인자를 넣어주기
		q.add(new Node(i, j));

		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.x + dr[d];
				int nc = curr.y + dc[d];

				// 1. 범위체크
				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				// 2. 괴물이 있으면 패스
				if (graph[nr][nc] == 0)
					continue;
				// 3. 아직 한번도 간 적 없는 길이면! 갈 수 있다
				if (graph[nr][nc] == 1) {
					graph[nr][nc] = graph[curr.x][curr.y] + 1;
					q.add(new Node(nr, nc));
				}

			}

		}

	}

}