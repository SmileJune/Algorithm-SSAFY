package com.ssafy.yun;

import java.util.Scanner;

public class Baek_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		String str = sc.nextLine();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.parseInt(str.substring(i, i + 1));
		}
		System.out.println(sum);
	}

}
