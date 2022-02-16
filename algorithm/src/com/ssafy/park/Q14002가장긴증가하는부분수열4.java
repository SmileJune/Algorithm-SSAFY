package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14002가장긴증가하는부분수열4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Flong(arr);

	}

	public static void Flong(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int temp = 0;
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					temp = dp[j] + 1;
				}
				max = Math.max(max, temp);
			}
			dp[i] = max;
		}
		int Lis = 0;
		int idx = 0;
		for (int i = 0; i < dp.length; i++) {
			if (Lis < dp[i]) {
				Lis = dp[i];
				idx = i;
			}
		}
		System.out.println(Lis);
		List result = new ArrayList();
		for (int i = idx; i >= 0; i--) {
			if (dp[i] == Lis) {
				result.add(0,arr[i]);
				Lis -= 1;
			}
		}
		System.out.print(result.get(0));
		for (int i = 1; i < result.size(); i++) {
			System.out.print(" "+ result.get(i));
		}
	}
}
