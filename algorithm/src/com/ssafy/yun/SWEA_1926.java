package com.ssafy.yun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SWEA_1926 {

	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			bw.write(solution(i) + " ");
		}
		bw.close();
	}

	public static String solution(int input) {
		int num = input;
		StringBuffer sb = new StringBuffer();
		int digit = 0;
		while (num > 0) {
			digit = num % 10;
			num /= 10;
			if (check(digit)) {
				sb.append("-");
			}
		}
		String str = sb.toString();
		if (str.equals(""))
			return "" + input;

		return str;
	}

	public static boolean check(int num) {
		if (num == 0)
			return false;
		if (num % 3 == 0)
			return true;

		if (num % 6 == 0)
			return true;

		if (num % 9 == 0)
			return true;

		return false;
	}

}
