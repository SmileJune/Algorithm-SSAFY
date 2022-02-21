package com.ssafy.ehoi;

import java.util.Scanner;

public class Day14_BOJ_B2_8958_OXQuiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			String str = sc.next();
			int score = 0; int cnt = 0;
			for (int i = 0; i < str.length(); i++ ) {
				char c = str.charAt(i);
				if (c == 'O') { // 맞으면 
					score += ++cnt;
				} else { // 틀리면
					cnt = 0;
				}
			}
			System.out.println(score);
			
		}
		
		sc.close();
	}
}
