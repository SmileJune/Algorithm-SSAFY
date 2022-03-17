package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day38_BOJ_B1_1546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 시험 과목수 1000 이하
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] score = new double[N];
		double max = 0;
		for (int i = 0; i < N; i++) {
			score[i] = Double.parseDouble(st.nextToken());
			if (score[i] > max) {
				max = score[i];
			}
		}
//		System.out.println(Arrays.toString(score));
//		System.out.println(max);
		double sum = 0;
		for (int i = 0; i < N; i++) {
			score[i] = score[i]/max*100;
			sum += score[i];
		}
//		System.out.println(Arrays.toString(score));
		double ans = sum / N;
		System.out.println(ans);
		
	}
}
