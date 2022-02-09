package com.ssafy.park;

import java.util.Arrays;
import java.util.Scanner;

public class day01S1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		String[] num = str.split(" ");
		int[] num2 = new int[num.length];
		for (int i = 0; i<num.length; i++) {
			num2[i] = Integer.parseInt(num[i]);
		}
		Arrays.sort(num2);
		int result = 0;
		if (num1 == 1) {
			result = num2[0] * num2[0];
		} else {
			result = num2[0] * num2[(num2.length)-1];
		}
		System.out.println(result);
	}
}