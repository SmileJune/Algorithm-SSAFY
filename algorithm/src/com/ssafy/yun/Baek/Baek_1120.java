package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1120 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		String str2 = st.nextToken();

		int dis = 0;
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i))
					dis++;
			}
			System.out.println(dis);
			return;
		}

		int min = str1.length();
		for (int i = 0; i < str2.length() - str1.length() + 1; i++) {
			dis = 0;
			for (int j = 0; j < str1.length(); j++) {
				if (str2.charAt(j + i) != str1.charAt(j))
					dis++;
			}
			min = Math.min(min, dis);
		}
		System.out.println(min);

	}

}
