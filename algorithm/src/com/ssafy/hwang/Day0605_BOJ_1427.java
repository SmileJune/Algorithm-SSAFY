package com.ssafy.hwang;

import java.util.Arrays;
import java.util.Scanner;

public class Day0605_BOJ_1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] iArr = input.toCharArray();

		Arrays.sort(iArr);
		StringBuilder sb = new StringBuilder();
		for (int i = iArr.length - 1; i >= 0; i--) {
			sb.append(iArr[i]-'0');
		}
		System.out.println(sb);
	}
}
