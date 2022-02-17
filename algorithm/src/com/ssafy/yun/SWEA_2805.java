package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2805 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}

	}

	static int solution() throws NumberFormatException, IOException {
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = Math.abs(i - N / 2); j <= N - 1 - Math.abs(i - N / 2); j++) {
				sum += map[i][j];
			}
		}

		return sum;
	}

}
