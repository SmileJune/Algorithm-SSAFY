package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1984_중간평균값구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			int[] arr = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int sum = 0;
			for (int i = 1; i < 9; ++i) {
				sum += arr[i];
			}
			System.out.println("#" + t + " " + (int) (sum / 8.0 + 0.5));

		}
	}
}