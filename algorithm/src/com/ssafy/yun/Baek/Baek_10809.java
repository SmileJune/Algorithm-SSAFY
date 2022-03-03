package com.ssafy.yun;

import java.util.Scanner;

public class Baek_10809 {

	public static void main(String[] args) {
		int[] arr = new int[26];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		for (int i = str.length() - 1; i >= 0; i--) {
			arr[str.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}

	}

}
