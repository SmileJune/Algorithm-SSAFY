package com.ssafy.yun.Baek;

import java.math.BigInteger;
import java.util.Scanner;

public class Baek_1212 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();
		
		long num = 0;
		int n = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			num += (str.charAt(i) - '0') * Math.pow(8, n++);
		}
		System.out.println(toBinary(num));

	}

	static String toBinary(long num) {
		StringBuffer sb = new StringBuffer();
		while (num != 0) {
			sb.append(num % 2);
			num /= 2;
		}

		return sb.reverse().toString();
	}

}
