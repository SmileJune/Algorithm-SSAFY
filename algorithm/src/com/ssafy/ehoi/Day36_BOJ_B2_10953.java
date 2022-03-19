package com.ssafy.ehoi;

import java.util.Scanner;

public class Day36_BOJ_B2_10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			String str = sc.next();
			String[] array = str.split(",");
			int sum = 0;
			for (int j = 0; j < array.length; j++) {
				sum += Integer.parseInt(array[j]);
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
