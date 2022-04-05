package com.ssafy.yun.Baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_4963 {

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
	static int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 0, 0, -1, 1, -1, 1 };
	static int n, m, cnt;
	static Queue<Node> q;

	public static void main(String[] args) {
		while (true) {
			m = sc.nextInt();
			n = sc.nextInt();
			cnt = 0;
			if (m == 0 && n == 0) {
				return;
			}
			map = new int[n][m];
			q = new LinkedList<>();
			visited = new boolean[n][m];
			solution();
		}
	}

	static void solution() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isInRange(i, j)) {
					q.add(new Node(i, j));
					visited[i][j] = true;
					cnt++;
					checkOne();
				}
			}
		}

		System.out.println(cnt);
	}

	static void checkOne() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int k = 0; k < dr.length; k++) {
				int nr = node.r + dr[k];
				int nc = node.c + dc[k];

				if (isInRange(nr, nc)) {
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

	static boolean isInRange(int i, int j) {
		// 범위
		if (i < 0 || n <= i || j < 0 || m <= j) {
			return false;
		}
		// 방문
		if (visited[i][j] == true) {
			return false;
		}
		// 1이냐
		if (map[i][j] != 1) {
			return false;
		}
		return true;
	}

}
