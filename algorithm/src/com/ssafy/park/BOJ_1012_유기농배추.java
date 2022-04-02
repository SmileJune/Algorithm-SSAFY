package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean arr[][];
	static boolean check[][];
	static int m, n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int textCnt = Integer.parseInt(br.readLine());
		int ans;

		for (int i = 0; i < textCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			arr = new boolean[n][m];
			check = new boolean[n][m];

			ans = 0;

			for (int j = 0; j < cnt; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = true;
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (checkLocation(j, k) == true) {
						ans++;
						dfs(j, k);
					}
				}
			}

			sb.append(ans + "\n");
		}

		System.out.println(sb);
	}

	public static boolean checkLocation(int row, int col) {
		
		if (row < 0 || row >= n || col < 0 || col >= m)
			return false;
	
		if (check[row][col] == true || arr[row][col] == false)
			return false;
		return true;
	}

	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		if (checkLocation(x - 1, y))
			dfs(x - 1, y);
		
		if (checkLocation(x, y + 1))
			dfs(x, y + 1);
		
		if (checkLocation(x + 1, y))
			dfs(x + 1, y);
	
		if (checkLocation(x, y - 1))
			dfs(x, y - 1);
	}

}