package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1157 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();

		str = str.toUpperCase();

		int[] arr = new int[26];

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}

		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int cnt = 0;
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				cnt++;
				idx = i;
			}
		}

		if (cnt > 1) {
			System.out.println("?");
			return;
		}

		System.out.println((char) (idx + 'A'));
	}

}
