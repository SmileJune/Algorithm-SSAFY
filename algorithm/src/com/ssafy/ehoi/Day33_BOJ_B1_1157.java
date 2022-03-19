package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day33_BOJ_B1_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int[] cnt = new int['z'-'a'+1];
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('A' <= c && c <= 'Z') {
				cnt[c - 'A']++;
			} else if ('a' <= c && c <= 'z') {
				cnt[c - 'a']++;
			}
		}
		
		String ans = "";
		int max = -1;
//		int maxIdx = -1;
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
				ans = (char)(i + 'A') + "";
			} else if (cnt[i] == max) {
				ans = "?";
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
