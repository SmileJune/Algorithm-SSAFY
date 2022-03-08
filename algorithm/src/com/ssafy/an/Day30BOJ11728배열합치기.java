package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day30BOJ11728배열합치기 { // 11728배열합치기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] brr = new int[M];
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		idx = 0;
		while (st.hasMoreTokens()) {
			brr[idx++] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		Arrays.sort(brr);

		idx = 0;
		int jdx = 0;
		while (idx < N && jdx < M) {
			if (arr[idx] < brr[jdx]) {
				sb.append(arr[idx++] + " ");
			} else {
				sb.append(brr[jdx++] + " ");
			}
		}

		while (idx < N) {
			sb.append(arr[idx++] + " ");
		}
		
		while (jdx < M) {
			sb.append(brr[jdx++] + " ");
		}

		System.out.println(sb);
		br.close();
	}
}
