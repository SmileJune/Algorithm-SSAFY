package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day7MainSolution2217 { // 2217 로프, 특정 줄로 최대 무게 들기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		int max = 0;
		for (int n = 0; n < N; n++) {
			rope[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		for (int n = 0; n < N; n++) {
			max = Math.max(max, rope[n] * (N - n));
		}
		System.out.println(max);

		br.close();
	}
}
