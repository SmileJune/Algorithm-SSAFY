package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6485_삼성시의버스노선{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			int P = Integer.parseInt(br.readLine());
			int[] C = new int[P];
			int[] ans = new int[P];
			for (int i = 0; i < P; ++i) {
				C[i] = Integer.parseInt(br.readLine());
				for(int j = 0; j < N; ++j) {
					if(A[j] <= C[i] && C[i] <= B[j]) {
						ans[i]++;
					}
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < P; ++i) {
				sb.append(ans[i]).append(" ");
			}
			System.out.println(sb);
		}
	}
}