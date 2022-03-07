package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int E = 15;
		int S = 28;
		int M = 19;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if (arr[0] == E) arr[0] = 0;
		if (arr[1] == S) arr[1] = 0;
		if (arr[2] == M) arr[2] = 0;
 		int ans = 1;
		while (true) {
			if (ans % E == arr[0] && ans % S == arr[1] && ans % M == arr[2]) break;
			ans++;
		}
		System.out.println(ans);
	}
}
