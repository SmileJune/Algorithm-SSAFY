package com.ssafy.hwang;

import java.util.Scanner;

public class Day32_BOJ_수이어쓰기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;	
		String s = sc.next();
		int i = 1;
		outer : while(true){
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			for (int j = 0; j < sb.length(); j++) {
				if (s.charAt(0) == sb.charAt(j)) {
						s = s.substring(1);
					 if(s.length()==0){
						 ans = Integer.parseInt(sb.toString());
						break outer;
					}
				}
			}
			i++;
		}
		System.out.println(ans);
	}
}
