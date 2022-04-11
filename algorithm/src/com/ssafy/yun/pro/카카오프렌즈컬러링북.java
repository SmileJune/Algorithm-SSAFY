package com.ssafy.yun.pro;

import java.util.Arrays;

public class 카카오프렌즈컬러링북 {
	static int numberOfArea = 0;
	static int maxSizeOfOneArea = 0;
	static int sizeOfOneArea = 0;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}

	static public int[] solution(int m, int n, int[][] picture) {
		visited = new boolean[m][n];
		checkAllpoints(m, n, picture);
		return new int[] { numberOfArea, maxSizeOfOneArea };
	}

	static private void checkAllpoints(int m, int n, int[][] picture) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				checkAPoint(m, n, picture, i, j);
			}
		}
	}

	static private void checkAPoint(int m, int n, int[][] picture, int i, int j) {
		if (picture[i][j] != 0 && visited[i][j] == false) {
			dfs(i, j, picture, m, n, picture[i][j]);
			numberOfArea++;
			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
			sizeOfOneArea = 0;
		}
	}

	static void dfs(int i, int j, int[][] picture, int m, int n, int pivotnumber) {
		if (i < 0 || m <= i || j < 0 || n <= j) {
			return;
		}
		if (visited[i][j]) {
			return;
		}
		if (picture[i][j] != pivotnumber) {
			return;
		}
		visited[i][j] = true;
		sizeOfOneArea++;

		for (int k = 0; k < 4; k++) {
			dfs(i + dx[k], j + dy[k], picture, m, n, pivotnumber);
		}
	}
}
