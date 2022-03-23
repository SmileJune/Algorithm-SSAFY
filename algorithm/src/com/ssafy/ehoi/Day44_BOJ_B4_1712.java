package com.ssafy.ehoi;

import java.util.Scanner;

public class Day44_BOJ_B4_1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int ans = 0;
		if(c - b <= 0) ans = -1;
		else {
			ans = (a / (c-b)) + 1;
		}
		System.out.println(ans);
		sc.close();
	}
}
