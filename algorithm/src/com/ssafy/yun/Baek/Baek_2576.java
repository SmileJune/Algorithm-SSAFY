package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_2576 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[7];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int sum = 0;
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				sum += arr[i];
				check = true;
				continue;
			}
		}
		if(check==false) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sum);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				System.out.println(arr[i]);
				return;
			}
		}
	}

}
