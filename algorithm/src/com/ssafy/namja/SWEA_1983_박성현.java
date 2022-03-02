package com.ssafy.namja;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1983_박성현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		String[] grades = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int n = N / 10;
			double[] scores = new double[N];
			for (int i = 0; i < N; i++) {
				double score = sc.nextInt() * 0.35 + sc.nextInt() * 0.45 + sc.nextInt() * 0.2;
				scores[i] = score;
			}
			double[] scores_sorted = Arrays.copyOf(scores, scores.length);
			Arrays.sort(scores_sorted);

			double selScore = scores[K - 1];
			int idx = -1;
			for (int i = 0; i < scores_sorted.length; i++) {
				if (scores_sorted[i] == selScore)
					idx = i;
			}
			System.out.printf("#%d %s\n", t, grades[idx / n]);
		}
	}
}