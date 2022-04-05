package com.ssafy.yun.SWEA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7733 {
	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] visitedCopy;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int n;
	static Queue<Node> q;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n", tc, solution());
		}
	}

	static int solution() {
		n = sc.nextInt();
		q = new LinkedList<>();
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= 100; i++) {
			// 해당 번호 방문체크하고
			eat(i);
			// 갯수 확인
			max = Math.max(max, check());
		}

		return max;
	}

	static int check() {
		visitedCopy = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visitedCopy[i][j] = visited[i][j];
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visitedCopy[i][j] == true) {
					continue;
				}
				// false일때
				q.add(new Node(i, j));
				visitedCopy[i][j] = true;
				cnt++;

				while (!q.isEmpty()) {
					Node node = q.poll();
					for (int d = 0; d < dr.length; d++) {
						int nr = node.r + dr[d];
						int nc = node.c + dc[d];

						if (!isInRange(nr, nc)) {
							continue;
						}

						q.add(new Node(nr, nc));
						visitedCopy[nr][nc] = true;
					}
				}

			}
		}
		return cnt;
	}

	static void eat(int day) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == day) {
					visited[i][j] = true;
				}
			}
		}
	}

	static boolean isInRange(int r, int c) {
		// 범위체크
		if (r < 0 || n <= r || c < 0 || n <= c) {
			return false;
		}
		// 방문체크
		if (visitedCopy[r][c] == true) {
			return false;
		}
		return true;
	}

}
