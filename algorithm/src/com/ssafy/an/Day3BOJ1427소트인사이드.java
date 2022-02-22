package com.ssafy.an;

import java.util.Arrays;
import java.util.Scanner;

public class Day3BOJ1427소트인사이드 { // 1427
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strNum = str.split("");
		int[] num = new int[str.length()];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(strNum[i]);
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[num.length - 1 - i]);
		}
		sc.close();
	}
}
