package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Day156BOJ1339단어수학 {
	static int N;
	static Integer[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Integer[26];

		Arrays.fill(arr, 0);
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int w = 0; w < s.length(); w++) {
				arr[s.charAt(w) - 'A'] += (int) Math.pow(10, s.length() - 1 - w);
			}
		}
		Arrays.sort(arr, Collections.reverseOrder());

		int sum = 0;
		int num = 9;
		int idx = 0;
		while (arr[idx] != 0) {
			sum += num-- * arr[idx++];
		}

		System.out.println(sum);
		br.close();
	}
}