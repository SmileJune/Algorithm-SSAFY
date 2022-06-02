package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day08BOJ17413단어뒤집기2 { // 17413번 글자 뒤집기 2
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		String str = br.readLine();
		// 공백과 <, >을 만날 때마다 조건
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '<') {
				tmp = reverSe(tmp);
				sb.append(tmp);
				tmp = new StringBuilder();
				flag = true;
			}
			if (flag == true)
				sb.append(c); // 정방향 입력
			if (c == '>') // >까지 넣고 불린값 변경
				flag = false;

			if (c != '>' && flag == false) {
				if (c == ' ') {
					tmp = reverSe(tmp);
					sb.append(tmp);
					sb.append(c);
					tmp = new StringBuilder();
				} else
					tmp.append(c);
			}

		}
		tmp = reverSe(tmp);
		sb.append(tmp);

		System.out.println(sb);
	}

	private static StringBuilder reverSe(StringBuilder tmp) {
		String str = tmp.substring(0);
		tmp = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			tmp.append(str.charAt(i));
		}

		return tmp;
	}
}
