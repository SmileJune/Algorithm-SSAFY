package com.ssafy.namja;

import java.util.Scanner;
public class BOJ_1411_박성현 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			int N = sc.nextInt();
			sc.nextLine();
			
			String[] words = new String[N];
			for (int i = 0; i < N; i++) {
				words[i] = sc.nextLine();
			}
			
			int length = words[0].length();
			int[][] check = new int[N][length];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < length; j++) {
					for (int k = j; k < length; k++) {
						if (check[i][k] == 0 && words[i].charAt(k) == words[i].charAt(j))
							check[i][k] = j + 1;
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < N - 1; i++) {
				StringBuffer word1 = new StringBuffer("");
				for (int j = 0; j < length; j++) {
					word1.append(check[i][j]);
				}
				for (int k = i + 1; k < N; k++) {
					StringBuffer word2 = new StringBuffer("");
					for (int j = 0; j < length; j++) {
						word2.append(check[k][j]);
					}
					if (word1.toString().equals(word2.toString()))
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
