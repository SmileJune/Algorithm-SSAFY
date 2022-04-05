package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1076 {

	static String[] arr;
	static String str;
	static Scanner sc = new Scanner(System.in);
	static StringBuffer sb;

	public static void main(String[] args) {
		arr = new String[] { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
		sb = new StringBuffer();
		str = sc.nextLine();
		for (int i = 0; i < arr.length; i++) {
			if (sb.length() == 0 && str.equals("black")) {
				break;
			}
			if (str.equals(arr[i])) {
				sb.append(i);
				break;
			}
		}

		str = sc.nextLine();
		for (int i = 0; i < arr.length; i++) {
			if (str.equals(arr[i])) {
				sb.append(i);
				break;
			}
		}
		str = sc.nextLine();
		for (int i = 0; i < arr.length; i++) {
			if (str.equals(arr[i])) {
				for (int j = 0; j < i; j++) {
					sb.append("0");
				}
			}
		}
		System.out.println(sb);

	}

}
