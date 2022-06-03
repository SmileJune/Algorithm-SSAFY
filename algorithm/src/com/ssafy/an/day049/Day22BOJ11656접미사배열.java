package com.ssafy.an.day049;

import java.util.Arrays;
import java.util.Scanner;

public class Day22BOJ11656접미사배열 { // 11656 접미사 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int N = str.length();
		String[] ans = new String[N];
		for (int i = 0; i < N; i++) {
			ans[i] = str.substring(i, N);
		}
		Arrays.sort(ans); 
		// 1문자가 같거나, 길이가 다른 글자 끼리 비교가 어려움
		for (int i = 0; i < N; i++) {
			System.out.println(ans[i]);
		}
		sc.close();
	}
}
