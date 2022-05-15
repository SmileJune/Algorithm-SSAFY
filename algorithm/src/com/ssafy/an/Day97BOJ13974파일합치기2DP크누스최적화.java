package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day97BOJ13974파일합치기2DP크누스최적화 { // 13974 파일 합치기 2 DP 크누스최적화
	static int T, K;
	static int[] arr, sum;
	static int[][] dp, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			K = Integer.parseInt(br.readLine());
			arr = new int[K + 1];
			sum = new int[K + 1];
			num = new int[K + 1][K + 1];
			dp = new int[K + 1][K + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < K + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + arr[i]; // 부분합 배열
				num[i - 1][i] = i; // 크누스 알고리즘
			}
			for (int n = 2; n < K + 1; n++) { // n차이값인데, 이미 i-1과 i값은 초기화되어있다.
				for (int i = 0; i + n < K + 1; i++) {
					int j = i + n;
					dp[i][j] = Integer.MAX_VALUE;
					for (int k = num[i][j - 1]; k < num[i + 1][j] + 1; k++) {
						int v = dp[i][k] + dp[k][j] + sum[j] - sum[i];
						if (dp[i][j] > v) {
							dp[i][j] = v; // 최소값으로 갱신
							num[i][j] = k; // 최소값 k를 찾아 보존
						}
					}
//					sb.append(print(num) + "\n"); // 최소값 num배열 출력
				}
			}

			sb.append(dp[0][K] + "\n"); // 1~K가 아닌, 0~K
		}
		System.out.println(sb);
		br.close();
	}

	private static String print(int[][] a) {
		StringBuilder t = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				t.append(String.format("%3d", a[i][j]));
			t.append("\n");
		}
		return t.toString();
	}
}
// 기존 index i <= k < j 
// dp[i][j] = min(i <= k < j){dp[i][k] + dp[k+1][j]} + psum[i][j]
// 변경 index i < k < j 
// dp[i][j] = min(i < k < j){dp[i][k] + dp[k][j]} + psum[i][j]
// 기존에는 최소비용의 k값을 i 자기 자신까지 비교하여 최소비용을 유지 하지만,
// 크누스 알고리즘에서는 k값을 i와 j
