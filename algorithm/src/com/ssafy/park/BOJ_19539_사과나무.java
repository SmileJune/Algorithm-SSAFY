package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19539_사과나무 {
	static int N;
	static Integer[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum2 = 0;
		int sum1 = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum2 += arr[i] / 2;
			sum1 += arr[i] % 2;
		}
		if (sum2 < sum1) {
			sb.append("NO");
		} else {			
			if ((sum2 - sum1) % 3 != 0) {
				sb.append("NO");
			} else {
				sb.append("YES");
			}
		}
		System.out.println(sb);
	}
}
