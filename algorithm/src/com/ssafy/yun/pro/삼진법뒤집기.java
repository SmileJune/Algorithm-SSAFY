package com.ssafy.yun.pro;

public class 삼진법뒤집기 {
	public static void main(String[] args) {
		int n = 125;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		StringBuffer sb = new StringBuffer();
		return Integer.parseInt(reversedString(n, sb), 3);
	}

	static String reversedString(int n, StringBuffer sb) {

		if (n / 3 >= 1) {
			sb.append(n % 3);
			n /= 3;
		} else {
			sb.append(n);
			return sb.toString();
		}

		return reversedString(n, sb);
	}
}
