package com.ssafy.hwang;

import java.util.Scanner;

public class BOJ_11655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				if ((s.charAt(i) - 'A') >= 0&&(s.charAt(i) - 'A') < 13) {
					System.out.print((char) ((s.charAt(i) +13)));
				} 
				else {
					System.out.print((char) ((s.charAt(i) - 13)));
				}
			}
			
			else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				if((s.charAt(i) - 'a') >= 0&&(s.charAt(i) - 'a') < 13) {
					System.out.print((char) ((s.charAt(i) +13)));
				}
				else {
					System.out.print((char) ((s.charAt(i) - 13)));
				}
			}
			else {
				System.out.print(s.charAt(i));
			}
		}
	}
}
