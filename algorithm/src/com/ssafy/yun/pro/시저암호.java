package com.ssafy.yun.pro;

public class 시저암호 {
	public static void main(String[] args) {
		String s = "AB";
		int n = 1;
		System.out.println(solution(s, n));

	}

	public static String solution(String s, int n) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			sb.append(encrypt(s.charAt(i), n));
		}

		return new String(sb);

	}

	static char encrypt(char element, int n) {
		if (element == ' ') {
			return element;
		}

		int newElement = element + n;

		if (newElement > 'z') {
			newElement -= 26;
			return (char) newElement;
		}

		if (element <= 'Z') {
			if (newElement > 'Z') {
				newElement -= 26;
				return (char) newElement;
			}
		}
		return (char) newElement;
	}
}
