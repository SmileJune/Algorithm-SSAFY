package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day38_BOJ_B1_4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 학생 수
			int[] score = new int[N];
			double sum = 0;
			for (int j = 0; j < N; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				sum += score[j];
			}
//			System.out.println(N);
//			System.out.println(Arrays.toString(score));
			double avg = sum/N;
			
			double cnt = 0;
			for (int j = 0; j < N; j++) {
				if (score[j] > avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", (cnt/N)*100 );
			
		}
	}
}
