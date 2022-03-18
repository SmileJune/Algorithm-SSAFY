package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2562 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int index = 0;
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				index = i;
				max = arr[i];
			}
		}
		
		System.out.println(max);
		System.out.println(index);
	}

}
