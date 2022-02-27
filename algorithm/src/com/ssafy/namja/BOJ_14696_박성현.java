package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_14696_박성현 {
	/* 별(=4) > 동그라미(=3) > 네모(=2) > 세모(=1) */
	/*
	 * 입력 N (:총 라운드 수) 라운드 1에 a가 내는 딱지 라운드 2에 a가 내는 딱지 ~ N라운드까지
	 */

	/*
	 * 출력 각 라운드의 승부 결과 (A가 승리시 A, B가 승리시 B, 무승부시 D)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 총 라운드 수

		char[] shobu = new char[N]; // 승부 결과
		for (int i = 0; i < N; i++) {
			int[] aDdak = new int[4]; // A가 낼 딱지
			int[] bDdak = new int[4]; // B가 낼 딱지
			int a = sc.nextInt();
			for (int j = 0; j < a; j++)
				aDdak[sc.nextInt() - 1]++;
			int b = sc.nextInt();
			for (int j = 0; j < b; j++)
				bDdak[sc.nextInt() - 1]++;

			boolean flag = true;
			for (int j = 3; j >= 0; j--) {
				if (aDdak[j] == bDdak[j])
					continue;
				else if (aDdak[j] > bDdak[j])
					shobu[i] = 'A';
				else
					shobu[i] = 'B';
				flag = false;
				break;
			}
			if (flag)
				shobu[i] = 'D';
		}
		for (int i = 0; i < N; i++)
			System.out.println(shobu[i]);
	}
}
