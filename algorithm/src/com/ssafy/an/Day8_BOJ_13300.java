package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day8_BOJ_13300 { // 13300
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rooms = 0;
		int[][] arr = new int[2][7];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[m][y]++;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				rooms += Math.ceil((double) arr[i][j] / K);
			}
		}

		System.out.println(rooms);
		br.close();
	}
}
