package com.ssafy.hwang;

import java.util.Scanner;

public class Day05_BOJ10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		for(int i =0; i<s.length();i++) {
			
			s.replace(s.charAt(i), (char)(s.charAt(i)+13));
		}
		for(int i =0; i<s.length();i++) {
			System.out.print(s.charAt(i));
		}
	}
}