package com.ssafy.an.day249;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day204BOJ1035조각움직이기 {
	static Point[] points = new Point[5];
	static int pointsSize = 0;
	static boolean[][] map = new boolean[7][7];
	static boolean[][] visited = new boolean[7][7];
	static int min = 1987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n은 조각 개수
		for (int i = 1; i <= 5; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 1; j <= 5; j++) {
				if ("*".equals(strs[j - 1])) {
					points[pointsSize++] = new Point(i, j);
				}
			}
		}
		bruteForce(0, 0);
		System.out.println(min);
	}

	private static void bruteForce(int dep, int disSum) {
		if (disSum >= min)
			return;

		if (dep == pointsSize) {
			if (allConnected())
				min = Math.min(min, disSum);
			return;
		}

		// depth까지 다음 지점 탐색
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (map[i][j])
					continue;

				map[i][j] = true;
				int dis = Math.abs(points[dep].x - i) + Math.abs(points[dep].y - j);
				bruteForce(dep + 1, disSum + dis);
				map[i][j] = false;
			}
		}
	}

	private static boolean allConnected() {
		init(visited);
		return count(findFirstPoint()) == pointsSize;
	}

	private static int count(Point pnt) {
		int cnt = 1;
		int x = pnt.x, y = pnt.y;
		visited[x][y] = true;

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int k = 0; k < 4; k++) {
			int mx = x + dx[k];
			int my = y + dy[k];
			if (map[mx][my] && !visited[mx][my]) {
				cnt += count(new Point(mx, my));
			}
		}
		return cnt;
	}

	private static Point findFirstPoint() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j])
					return new Point(i, j);
			}
		}
		return new Point(-1, -1);
	}

	private static void init(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = false;
			}
		}
	}
}
