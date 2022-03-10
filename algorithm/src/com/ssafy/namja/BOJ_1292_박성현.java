package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1292_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		int cnt = 1;
		int num = 1;
		int sum = 0;
		while (cnt <= B) {
			for (int i = 0; i < num; i++) {
				if (cnt >= A && cnt <= B)
					sum += num;
				cnt++;
			}
			num++;
		}
		System.out.println(sum);
	}
}