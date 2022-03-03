package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += check(str.charAt(i));
		}
		System.out.println(sum);
	}

	public static int check(char ch) {
		if (ch <= 'C')
			return 3;
		if (ch <= 'F')
			return 4;
		if (ch <= 'I')
			return 5;
		if (ch <= 'L')
			return 6;
		if (ch <= 'O')
			return 7;
		if (ch <= 'S')
			return 8;
		if (ch <= 'V')
			return 9;
		if (ch <= 'Z')
			return 10;
		return 11;
	}
}
