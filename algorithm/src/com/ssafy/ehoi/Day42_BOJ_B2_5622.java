package com.ssafy.ehoi;

import java.util.Scanner;

public class Day42_BOJ_B2_5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int num = 0;
			char ch = str.charAt(i);
			switch (ch) {
			case 'A':
			case 'B':
			case 'C':
				num = 3;
				break;
			case 'D':
			case 'E':
			case 'F':
				num = 4;
				break;
			case 'G':
			case 'H':
			case 'I':
				num = 5;
				break;
			case 'J':
			case 'K':
			case 'L':
				num = 6;
				break;
			case 'M':
			case 'N':
			case 'O':
				num = 7;
				break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				num = 8;
				break;
			case 'T':
			case 'U':
			case 'V':
				num = 9;
				break;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				num = 10;
				break;
			}
			sum += num;
		}
		System.out.println(sum);
		sc.close();
	}
}
