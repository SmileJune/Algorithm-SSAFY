package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_3052_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] remains = new int[42];
		int cnt = 0;
		
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			if (remains[num % 42] == 0) {
				remains[num % 42]++;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}