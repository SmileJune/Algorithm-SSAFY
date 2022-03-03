package com.ssafy.ehoi;

import java.util.Scanner;

public class Day24_BOJ_B2_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] num = new int[26];
		for (int i =0; i < num.length; i++) {
			num[i] = -1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (num[str.charAt(i) - 'a'] == -1) { // 해당 알파벳이 나온 적이 한 번도 없다면 
				num[str.charAt(i) - 'a'] = i;
			}
		}
		
		for (int i = 0; i < num.length; i++) {
			
			System.out.print(num[i]+" ");
		}
		
		sc.close();
	}
}
