package com.ssafy.yun.pro;

import java.util.regex.Pattern;

public class 문자열내p와y의갯수 {

	public static void main(String[] args) {
		System.out.println(solution("pPoooyY"));
	}

	static boolean solution(String s) {
		String p_str = "pP";
		String y_str = "yY";
		int p = 0, y = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Pattern.matches(p_str, s.substring(i, i + 1))) {
				p++;
			}
			if (Pattern.matches(y_str, s.substring(i, i + 1))) {
				y++;
			}

		}

		if (p == y) {
			return true;
		} else {
			return false;
		}
	}
}