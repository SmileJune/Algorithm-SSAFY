package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759_암호만들기 {
	private static String[] arr;
	private static int l, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		l = Integer.parseInt(tmp[0]);
		c = Integer.parseInt(tmp[1]);

		arr = br.readLine().split(" ");
		Arrays.sort(arr);

		recur(0, "");
	}

	private static void recur(int idx, String str) {
		if (str.length() == l) {
			if (check(str)) {
				System.out.println(str);
			}
			return;
		}
		if (idx >= c) {
			return;
		}

		recur(idx + 1, str + arr[idx]);
		recur(idx + 1, str);
	}

	private static boolean check(String str) {
		int vowel = 0, consonant = 0;
		for (int i = 0; i < str.length(); i++) {
			if (cal(str.charAt(i))) {
				vowel++;
			} else {
				consonant++;
			}
		}
		return vowel >= 1 && consonant >= 2;
	}

	private static boolean cal(char ch) {
		return ch == 'a' | ch == 'e' | ch == 'i' | ch == 'o' | ch == 'u';
	}

}