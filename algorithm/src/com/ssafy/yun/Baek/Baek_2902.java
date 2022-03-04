package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2902 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(sc.nextLine());
		sb.insert(0, '-');

		StringBuffer ans = new StringBuffer();

		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '-') {
				ans.append(sb.charAt(i + 1));
			}
		}
		
		System.out.println(ans);
	}

}
