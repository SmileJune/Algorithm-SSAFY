package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2005_파스칼의삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N * 2 + 1];
			arr[0][(N * 2 + 1) / 2] = 1;
			for (int i = 1; i < N; ++i) {
//				for (int j = N / 2; j-i >= 0; ++j) {
//					arr[i][j] = arr[i][j-i];
//				}
				int j = (N * 2 + 1) / 2;
				int k = i % 2;
				while (j - k > 0) {
					if (k != 0)
						arr[i][j - k] += arr[i - 1][j - k - 1] + arr[i - 1][j - k + 1];
					arr[i][j + k] += arr[i - 1][j + k - 1] + arr[i - 1][j + k + 1];
					k++;
				}
			}
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N * 2 + 1; ++j) {
					if(arr[i][j] != 0)
						sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}
}