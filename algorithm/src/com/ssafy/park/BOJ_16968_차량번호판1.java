package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16968_차량번호판1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = 1;
		char temp = 'x';
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'd') {
				if (str.charAt(i) != temp) {					
					num *= 10;
					temp = str.charAt(i);
				} else {
					num *= 9;
				}
			} else {
				if (str.charAt(i) != temp) {
					num *= 26;
					temp = str.charAt(i);
				} else {
					num *= 25;
				}
			}
		}
		System.out.println(num);
	}
}
