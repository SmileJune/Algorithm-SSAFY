package com.ssafy.hwang;

import java.util.Scanner;

/**
 * [A+B-6]
 *
 */
public class Day36_BOJ_A더하기B_6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int A = 0;
			char[] arr = sc.next().toCharArray();
			
			for(int i =0 ; i<arr.length;i++) {
				if(arr[i]==',') {
					A += Integer.parseInt(sb.toString());
					sb.setLength(0);
					continue;
				}
				sb.append(arr[i]-'0');
			}
			A += Integer.parseInt(sb.toString());
			System.out.println(A);
			sb.setLength(0);
		}
	}

}
