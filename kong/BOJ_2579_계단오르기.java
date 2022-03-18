package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계단
		int[] step = new int[301];
        int[] score = new int[301];
		for (int i = 1; i <= N; ++i) {
			step[i] = Integer.parseInt(br.readLine());
		}
		score[1] = step[1];
        score[2] = step[1] + step[2];
        score[3] = Math.max(step[1], step[2]) + step[3];
        for (int n = 4; n <= N; n++) {
            score[n] = Math.max(score[n - 3] + step[n - 1], score[n - 2]) + step[n];
        }

        System.out.println(score[N]);
	}

}
