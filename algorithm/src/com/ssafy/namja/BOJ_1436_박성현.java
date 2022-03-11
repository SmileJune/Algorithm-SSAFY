package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1436_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int num = 666;
		int cnt = 1;
		while (true) {
			if (cnt == N)
				break;
			if ((++num + "").contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}