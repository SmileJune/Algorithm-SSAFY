package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1592_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// N : 자리수
		int M = sc.nextInt();	// M : 종료하기 위해 개인이 받아야 하는 횟수
		int L = sc.nextInt();	// L : 던지는 칸 수(홀수 - 시계 방향 / 짝수 - 반시계 방향)
		
		int[] seat = new int[N];
		
		int max_cnt = 1;
		int idx = 0;
		seat[idx] = 1;
		int sum = 0;
		while(max_cnt < M) {
			
			if (seat[idx] % 2 == 1) {
				for (int i = 1; i <= L; i++) {
					idx++;
					if (idx == N)
						idx = 0;
				}
				seat[idx]++;
			}
			else {
				for (int i = 1; i <= L; i++) {
					idx--;
					if (idx == -1)
						idx = N-1;
				}
				seat[idx]++;
			}
			for (int i = 0; i < N; i++) {
				max_cnt = Math.max(max_cnt, seat[i]);
			}
		}
		for (int i = 0; i < N; i++)
			sum += seat[i];
		System.out.println(sum-1);
		sc.close();
	}
}
