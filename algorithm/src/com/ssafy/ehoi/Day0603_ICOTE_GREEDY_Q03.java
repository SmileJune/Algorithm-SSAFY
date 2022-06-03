package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0603_ICOTE_GREEDY_Q03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		int cnt = 1; // 숫자가 다른 덩어리를 계산
		for (int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) != str.charAt(i+1)) {
				cnt++;
			}
		}
		
		System.out.println(cnt/2);
				
		sc.close();
	}
}