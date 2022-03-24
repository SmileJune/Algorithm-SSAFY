package com.ssafy.ehoi;

import java.util.Scanner;

public class Day45_BOJ_B5_2914 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int songs = sc.nextInt();
		int avg = sc.nextInt();

		int ans = (avg - 1) * songs + 1;
		System.out.println(ans);
		sc.close();
	}
}
