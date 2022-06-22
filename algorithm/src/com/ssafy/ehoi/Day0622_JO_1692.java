package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0622_JO_1692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String bStr = String.valueOf(b);
		
		for (int i = bStr.length() - 1; i >= 0; i--) {
			System.out.println(a * Integer.parseInt(bStr.charAt(i) + ""));
		}
		
		System.out.println(a * b);
		
		sc.close();
	}
}
