package com.ssafy.ehoi;

import java.util.Scanner;

public class Codeup1201 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("양수");
		} else if (num < 0) {
			System.out.println("음수");
		} else {
			System.out.println("0");
		}

		sc.close();
	}
}
