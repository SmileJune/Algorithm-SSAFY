package com.ssafy.yun;

import java.util.Scanner;

public class Baek_2577 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a = sc.nextInt() * sc.nextInt() * sc.nextInt();
		int[] arr = new int[10];
		while (a != 0) {
			arr[a % 10]++;
			a /= 10;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
