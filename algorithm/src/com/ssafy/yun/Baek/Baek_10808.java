package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_10808 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();

		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			arr[ch - 'a']++;
		}

		String ans = Arrays.toString(arr).replaceAll(",", "");
		System.out.println(ans.substring(1, ans.length() - 1));
	}

}
