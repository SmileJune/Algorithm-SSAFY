package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1094_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int bin = 0;
		for (char c : Integer.toBinaryString(X).toCharArray())
			bin += c - '0';
		System.out.println(bin);
	}
}