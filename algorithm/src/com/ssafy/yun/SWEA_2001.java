package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2001 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}

	}

	static int solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];

		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for (int i = 0; i < arr.length - M + 1; i++) {
			for (int j = 0; j < arr[i].length - M + 1; j++) {
				int sum = 0;
				for (int row = i; row < i + M; row++) {
					for (int col = j; col < j + M; col++) {
						sum += arr[row][col];
					}
				}
				max = Math.max(max, sum);
			}
		}

		return max;

	}
}
