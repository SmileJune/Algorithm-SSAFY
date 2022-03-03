package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1259 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		outer: while (true) {
			String str = sc.nextLine();

			if (str.equals("0")) {
				break;
			}

			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
					continue;
				}

				System.out.println("no");
				continue outer;
			}
			System.out.println("yes");

		}

	}

}
