package com.ssafy.woong;

import java.util.Arrays;
import java.util.Scanner;

public class B2810 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		sc.nextLine();
		char[] arr = sc.nextLine().toCharArray();
		int sum = 0;
		boolean flag = false;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'S') {
				sum += 1;
			} else if (arr[i] == 'L') {
				sum += 1;
				i++;
			}
		}
		System.out.println(arr.length > sum ? sum : arr.length);
	}
}

//사람수가 컵 갯수보다 많으면 => 컵 갯수 출력.
