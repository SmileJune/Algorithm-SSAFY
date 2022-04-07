package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_N_Queen {
	
	static int N;
	static int[] sel;
	static int ans = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sel = new int[N];
		queen(0);
		System.out.println(ans);
	}
	public static void queen(int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			sel[cnt] = i;
			if (check(cnt)) {
				queen(cnt + 1);
			}
		}
	}
	public static boolean check(int cnt) {
		for (int i = 0; i < cnt; i++) {
			if (sel[i] == sel[cnt]) return false;
			else if (Math.abs(i - cnt) == Math.abs(sel[i] - sel[cnt])) {
				return false;
			}
		}
		return true;
	}
}
