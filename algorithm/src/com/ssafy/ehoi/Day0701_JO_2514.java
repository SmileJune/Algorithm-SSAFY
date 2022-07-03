package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0701_JO_2514 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int KOI = 0;
		int IOI = 0;

		for (int i = 0; i < str.length() - 2; i++) {
			String sub = str.substring(i, i + 3);
			if(sub.equals("KOI")) {
				KOI++;
			}
			if(sub.equals("IOI")) {
				IOI++;
			}
		}
		System.out.println(KOI);
		System.out.println(IOI);
		sc.close();
	}
}
