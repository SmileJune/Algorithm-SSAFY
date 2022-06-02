package com.ssafy.an.day049;

import java.util.Scanner;

public class Day10BOJ2941크로아티아알파벳 { // 2941
	static String str;
	static int tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str = sc.nextLine();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			tmp = 0;
			if (isCroatia(i)) {
				i += tmp; // boolean에서 확인한 글자수 만큼 전진
			}
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	} // 이게.... 맞아?

	private static boolean isCroatia(int i) {
		char c1 = str.charAt(i);
		char c2 = ' ';
		char c3 = ' ';
		if (i + 1 < str.length())
			c2 = str.charAt(i + 1);
		else
			return false;
		
		if (i + 2 < str.length())
			c3 = str.charAt(i + 2);

		if (c1 == 'c') {
			if (c2 == '=' || c2 == '-') {
				tmp = 1;
				return true;
			}
		} else if (c1 == 'd') {
			if (c2 == '-') {
				tmp = 1;
				return true;
			} else if (c2 == 'z') {
				if (c3 == '=') {
					tmp = 2;
					return true;
				}
			}
		} else if (c1 == 'l') {
			if (c2 == 'j') {
				tmp = 1;
				return true;
			}
		} else if (c1 == 'n') {
			if(c2 == 'j') {
				tmp = 1;
				return true;
			}
		} else if(c1 == 's') {
			if(c2 == '=') {
				tmp = 1;
				return true;				
			}
		} else if(c1 == 'z') {
			if(c2 == '=') {
				tmp = 1;
				return true;				
			}
		}

		return false;
	}
}
