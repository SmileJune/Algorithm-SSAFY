package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day45BOJ9184신나는함수실행DP정보기억 { // 9184 함수기억
	static int dp[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		dp = new int[21][21][21];// 20까지

		while (true) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append('\n');

		}
		System.out.println(sb);
		br.close();
	}

	static int w(int a, int b, int c) {
		if (inRange(a, b, c) && dp[a][b][c] != 0) { // dp부분이 한번 방문했던 정보를 저장해서 사용하도록
			return dp[a][b][c];
		} // inRange() a,b,c가 20넘는 수가 있으니 체크해서 20값으로 바꿔야함.

		if (a <= 0 || b <= 0 || c <= 0) {// 문제에 주어진 재귀
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	} // 주어지는 수는 50까지 인데, 20까지만 사용해야함.
}
