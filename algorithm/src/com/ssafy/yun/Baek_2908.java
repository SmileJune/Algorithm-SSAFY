package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2908 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		String str1 = st.nextToken();
		String str2 = st.nextToken();

		int a = Integer.parseInt(change(str1));
		int b = Integer.parseInt(change(str2));

		if (a > b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}

	public static String change(String str) {
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length / 2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		return sb.toString();
	}
}
