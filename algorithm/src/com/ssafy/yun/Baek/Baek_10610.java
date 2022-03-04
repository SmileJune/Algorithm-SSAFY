package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_10610 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();
		char[] arr = str.toCharArray();

		Arrays.sort(arr);

		// 0이 없으면 아웃
		if (arr[0] != '0') {
			System.out.println(-1);
			return;
		}

		// 합이 3으로 안나뉘어지면 아웃
		if (arrSum(arr) % 3 != 0) {
			System.out.println(-1);
			return;
		}

		//?? 이건 왜 안되지?
//		String ans = arr.toString().replaceAll(", ", "");
//		ans = ans.substring(1, ans.length() - 1);
//		StringBuffer sb = new StringBuffer(ans);
//		System.out.println(sb.reverse());
		
		StringBuffer sb = new StringBuffer();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);

	}

	static int arrSum(char[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] - '0';
		}
		return sum;
	}

}
