package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1436_2 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int num = 666;
		int cnt = 1;

		while (true) {
			if (cnt == N) {
				break;
			}
			num++;
			if (("" + num).contains("666")) {
				cnt++;
			}
		}

		System.out.println(num);

	}

}
