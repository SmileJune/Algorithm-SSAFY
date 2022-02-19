package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day12_BOJ_2527Fail { // 2527 100%에서 틀렸습니다는... 뭐지..
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int n = 0; n < 4; n++) {
			st = new StringTokenizer(br.readLine());
			int[][] num = new int[4][2];
			String ans = "a";
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (num[1][0] == num[2][0] && num[2][1] == num[1][1] || num[0][0] == num[3][0] && num[2][1] == num[1][1]|| num[1][0] == num[2][0] && num[3][1] == num[0][1]	|| num[3][0] == num[0][0] && num[0][1] == num[3][1])
				ans = "c";
			else if (num[1][0] == num[2][0] || num[0][0] == num[3][0] || num[1][1] == num[2][1] || num[0][1] == num[3][1])
				ans = "b";
			else if (num[1][0] < num[2][0] || num[1][1] < num[2][1] || num[3][0] < num[0][0] || num[3][1] < num[0][1])
				ans = "d";
			else
				ans = "a";
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
