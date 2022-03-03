package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = "" + N;
		if (N < 10) {
			str = "0" + str;
		}
		int cnt = 0;
		while (true) {
			int sumEachLetter = Integer.parseInt(str.substring(0, 1)) + Integer.parseInt(str.substring(1, 2));
			str = str.substring(str.length() - 1) + sumEachLetter % 10;
			cnt++;
			if (N==Integer.parseInt(str))
				break;
		}

		System.out.println(cnt);

	}

}
