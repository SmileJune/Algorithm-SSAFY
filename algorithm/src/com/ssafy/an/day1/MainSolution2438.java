package com.ssafy.an.day1;

import java.util.Scanner;

public class MainSolution2438 { // 2438 날먹
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = "*";
		for(int i = 0 ;i < n; i++) {
			System.out.println(s);
			s += '*';
		}
		sc.close();
	}
}
