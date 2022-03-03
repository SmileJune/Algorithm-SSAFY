package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_11721 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
			System.out.print(str.charAt(i));
		}

	}

}
