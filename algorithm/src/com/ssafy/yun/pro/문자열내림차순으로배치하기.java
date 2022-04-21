package com.ssafy.yun.pro;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}

	public static String solution(String s) {
		String[] arr = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.substring(i, i + 1);
		}

		Arrays.sort(arr);

		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			answer = arr[i] + answer;
		}

		return answer;
	}
}
