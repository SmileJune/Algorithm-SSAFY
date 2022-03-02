package com.ssafy.woong;

import java.util.Scanner;

public class B2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();

			int n = sc.nextInt();
			char[] str = sc.next().toCharArray();
			
			for(int i = 0; i < str.length; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(str[i]);
				}
			}
			
			System.out.println(sb);
		}
		
	}
}
