package com.ssafy.day1.hwang;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int divisorNum = sc.nextInt();

		int[] divisorArr = new int[divisorNum];

		for (int i = 0; i < divisorNum; i++) {
			divisorArr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(divisorArr);

		result = divisorArr[0] * divisorArr[divisorNum - 1];

		System.out.println(result);
	}
}
