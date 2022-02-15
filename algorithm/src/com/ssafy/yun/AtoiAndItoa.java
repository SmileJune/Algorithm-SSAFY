package com.ssafy.yun;

public class AtoiAndItoa {

	public static void main(String[] args) {
		System.out.println(atoi("-1223233"));
		System.out.println(itoa(-12323));

	}

	public static int atoi(String str) {

		int num = 0;
		int sign = 1;

		if (str.charAt(0) == '-') {
			sign = -1;
			str = str.substring(1);
		}

		for (int i = 0; i < str.length(); i++) {
			num = num * 10 + (str.charAt(i) - '0');
		}

		return sign * num;
	}

	public static String itoa(int num) {
		int sign = 1;
		if (num < 0) {
			sign = -1;
			num *= -1;
		}

		StringBuffer sb = new StringBuffer();

		int digit = num % 10;
		while (digit != 0) {
			sb.append((char) (digit + '0'));
			num /= 10;
			digit = num % 10;
		}
		
		sb = sb.reverse();
		if(sign == -1) {
			sb.insert(0, '-');
		}

		return sb.toString();
	}

}
