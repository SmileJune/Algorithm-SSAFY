package com.ssafy.an.day199;

import java.util.Scanner;

public class Day184BOJ1094막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int s = 64;
		int ans = 0;
		while (x > 0) {
			if (s > x)
				s /= 2;
			else {
				ans++;
				x -= s;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}