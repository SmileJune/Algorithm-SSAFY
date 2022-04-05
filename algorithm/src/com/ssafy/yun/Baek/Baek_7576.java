package com.ssafy.yun.Baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_7576 {

	static class Node {
		int r;
		int c;
		int len;

		Node(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static int n, m, lastLen;
	static Queue<Node> q;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		m = sc.nextInt();
		n = sc.nextInt();
		q = new LinkedList<>();
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					q.add(new Node(i, j, 0));
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			lastLen = node.len;
			for (int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				if (isInRange(nr, nc)) {
					q.offer(new Node(nr, nc, node.len + 1));
					visited[nr][nc] = true;
					map[nr][nc] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(lastLen);

	}

	static boolean isInRange(int i, int j) {
		// 범위 밖
		if (i < 0 || n <= i || j < 0 || m <= j) {
			return false;
		}

		// 방문했으면 안간다.
		if (visited[i][j] == true) {
			return false;
		}

		// 0이 아니면
		if (map[i][j] != 0) {
			return false;
		}

		return true;
	}

}
