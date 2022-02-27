package com.ssafy.namja;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] line = new int[N];
		for (int i = 0; i < N; i++)
			line[i] = sc.nextInt();
		Arrays.sort(line);
		int[] time = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += line[i];
			time[i] = sum;
		}
		int total = 0;
		for (int i = 0; i < N; i++)
			total += time[i];
		System.out.println(total);
	}
}
