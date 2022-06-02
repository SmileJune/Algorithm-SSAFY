package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day32BOJ2108통계학재도전 { // 2108 통계학
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] cnt = new int[8001];

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int mid_num = Integer.MIN_VALUE; // 0 안됨..
		int cnt_num = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			cnt[num + 4000]++;
			max = max < num ? num : max;
			min = min > num ? num : min;
		}
		int count = 0;
		int cnt_max = 0;
		boolean flag = false;
		for (int i = min + 4000; i <= max + 4000; i++) {
			if (cnt[i] > 0) {
				if (count < (N + 1) / 2) {
					count += cnt[i];
					mid_num = i - 4000;
				}
				if (cnt_max < cnt[i]) {
					cnt_max = cnt[i];
					cnt_num = i - 4000;
					flag = true;
				} else if (cnt_max == cnt[i] && flag == true) {
					cnt_num = i - 4000;
					flag = false;
				}
			}
		}
		System.out.println((int) Math.round((double) sum / N));
		System.out.println(mid_num);
		System.out.println(cnt_num);
		System.out.println(max - min);
		br.close();
	}
}
