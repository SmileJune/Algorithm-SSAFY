package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day56SW2112보호필름DFS { // SW 2112 보호필름
	static int D, W, K, ans;
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int d, int cnt) {
		if (check()) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (d == D || cnt > ans)
			return;

		dfs(d + 1, cnt); // 그냥 다음 행 진행

		int[] tmp = arr[d].clone(); // 값 보전

		Arrays.fill(arr[d], 0); // 현재 행을 0으로 바꾸고
		dfs(d + 1, cnt + 1); // 약품처리+1 후 다음 행 진행

		Arrays.fill(arr[d], 1); // 현재 행을 1으로 바꾸고
		dfs(d + 1, cnt + 1); // 약품처리+1 후 다음 행 진행

		arr[d] = tmp.clone(); // 값 원복

	}

	private static boolean check() {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			boolean flag = false;
			for (int i = 1; i < D; i++) {
				if (arr[i][j] == arr[i - 1][j])
					cnt++;
				else
					cnt = 1;

				if (cnt == K) {
					flag = true;
					break;
				}
			}
			if (!flag)
				return false;
		}
		return true;
	}
}
