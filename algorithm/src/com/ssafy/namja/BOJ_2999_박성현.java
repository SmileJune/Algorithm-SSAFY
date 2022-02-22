package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2999_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		int len = word.length();
		int R = 0;
		for (int i = 1; i <= Math.sqrt(len); i++) {
			if (len % i == 0)
				R = i;
		}
		int C = len / R;
		int idx = 0;
		char[][] msg = new char[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				msg[j][i] = word.charAt(idx++);
			}
		}
		
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				System.out.print(msg[i][j]);
	}
}
