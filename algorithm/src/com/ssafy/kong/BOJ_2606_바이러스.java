package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int[][] computer;
	static int N, M;
	static boolean[] visit;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		computer = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		StringTokenizer st;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int line1 = Integer.parseInt(st.nextToken());
			int line2 = Integer.parseInt(st.nextToken());
			computer[line1][line2] = computer[line2][line1] = 1;
		}
		recur(1);
		System.out.println(ans);
		
	}
	static void recur(int idx) {
		visit[idx] = true;
		for(int i = 1; i <= N; ++i) {
			if(computer[idx][i] == 1 && !visit[i]) {
				ans++;
				recur(i);
			}
		}
	}
}