package com.ssafy.an.day049;

import java.util.Scanner;

public class Day07BOJ10610삼십 { // 10610 30
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = str.split("");
		long total = 0;
		int[] cnt = new int[10];
		int[] arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
			cnt[arr[i]]++;
			total += arr[i];
		}

		if (!str.contains("0") || total % 3 != 0) {
			System.out.println("-1");
//			return; // 노란줄
		} else {
			for (int i = 9; i >= 0; i--) {
				while (cnt[i] > 0) {
					sb.append(i);
					cnt[i]--;
				}
			}
			System.out.println(sb);			
		}
		sc.close();
	}
}
