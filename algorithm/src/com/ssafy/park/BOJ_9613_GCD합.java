package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613_GCD합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j <N; j++) {
					int a = arr[i];
					int b = arr[j];
					int temp = 0;
					if ( a < b) {
						temp = a;
						a = b;
						b = temp;
					}
					long max = 0;
					for (int k = b; k > 0; k--) {
						if ( b % k == 0 && a % k == 0) {
							max = k;
							break;
						}
					}
					sum += max;
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}
