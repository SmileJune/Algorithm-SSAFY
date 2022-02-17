package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1974 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws IOException {
		boolean[] visited;
		int[][] map1 = new int[10][10];
		int[][] map2 = new int[10][10];

		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				map1[i][j] = num;
				map2[j][i] = num;
			}
		}

		for (int i = 1; i <= 9; i++) {
			visited = new boolean[10];
			for (int j = 1; j <= 9; j++) {
				if (visited[map1[i][j]] == true)
					return 0;
				visited[map1[i][j]] = true;
			}
		}
		for (int i = 1; i <= 9; i++) {
			visited = new boolean[10];
			for (int j = 0; j <= 9; j++) {
				if (visited[map2[i][j]] == true)
					return 0;
				visited[map2[i][j]] = true;
			}
		}

		for (int i = 1; i <= 9; i += 3) {
			for (int j = 1; j <= 9; j += 3) {
				visited = new boolean[10];
				for (int col = i; col < i + 3; col++) {
					for (int row = j; row < j + 3; row++) {
						if (visited[map1[col][row]] == true)
							return 0;
						visited[map1[col][row]] = true;
					}
				}
			}
		}

		return 1;
	}

}
