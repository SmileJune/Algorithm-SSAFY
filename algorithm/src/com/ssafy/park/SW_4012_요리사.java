package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4012_요리사 {
	static int N, ans, sum;
	static int[][] map;
	static int[] sel, sel2;
	static boolean[] visited, visited2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc =1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sel = new int[N/2];
			sel2 = new int[2];
			visited = new boolean[N];
			visited2 = new boolean[N];
			sum = 0;
			ans = Integer.MAX_VALUE;
			comb(0,0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	public static void comb(int idx, int sidx) {
		if (sidx ==  N/2) {
			cal(sel, 0);
			int a = sum;
			sum = 0;
			int[] temp = new int[N/2];
			int tidx = 0;
			for (int i = 0; i < N; i++) {
				if (!visited2[i]) {
					temp[tidx] = i;
					tidx++;
				}
			}
			cal(temp,0);
			int result = Math.abs(sum - a);
			ans = Math.min(result, ans);
			sum = 0;
			return;
		}
		for (int i = idx; i < N; i++) {
			sel[sidx] = i;
			visited2[i] = true;
			comb(i+1, sidx+1);
			visited2[i] = false;
		}
	}
	public static void cal(int[] arr, int sidx) {
		if (sidx == 2) {
			sum += map[sel2[0]][sel2[1]];
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) continue;
			sel2[sidx] = arr[i];
			visited[i] = true;
			cal(arr, sidx + 1);
			visited[i] = false;
		}
	}
}
