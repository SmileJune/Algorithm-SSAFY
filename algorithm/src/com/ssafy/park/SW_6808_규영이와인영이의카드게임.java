package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_6808_규영이와인영이의카드게임 {
	static int N = 9;
	static int[] arr;
	static int[] arr2;
	static int[] temparr2;
	static int result;
	static int result2;
	static int cntw;
	static int cntl;
	static boolean[] bo;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			arr = new int[N];
			arr2 = new int[N];
			temparr2 = new int[N];
			cntw = 0;
			cntl = 0;
			bo = new boolean[2 * N + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
				bo[num] = true;
			}
			int idx = 0;
			for (int i = 1; i < bo.length; i++) {
				if (!bo[i]) {
					arr2[idx] = i;
					idx++;
				}
			}
			duel(0,0);
			sb.append(cntw + " " + cntl + "\n");
		}
		System.out.println(sb);
	}

	public static void duel(int idx, int visited) {
		if (idx == N) {
			result = 0;
			result2 = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] > temparr2[i]) {
					result += arr[i] + temparr2[i];
				} else {
					result2 += arr[i] + temparr2[i];
				}
			}
			if (result > result2) {
				cntw++;
			} else if (result < result2) {
				cntl++;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((visited & 1 << i) != 0) {
				continue;
			}
			temparr2[idx] = arr2[i];
			duel(idx+1, visited | 1 << i);
		}
	}
}
