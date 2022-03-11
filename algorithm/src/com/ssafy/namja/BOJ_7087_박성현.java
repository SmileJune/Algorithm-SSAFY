package com.ssafy.namja;

import java.util.Arrays;
import java.util.Scanner;
public class BOJ_7087_박성현 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for (int t = 1; t <= T; t++) {
				int N = sc.nextInt();
				sc.nextLine();
				String[] words = new String[N];
				for (int i = 0; i < N; i++)
					words[i] = sc.nextLine();
				Arrays.sort(words);
				char head = 'A';
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					if (words[i].charAt(0) == head) {
						cnt++;
						head++;
					}
					else if (words[i].charAt(0) == head - 1)
						continue;
					else break;
				}
				System.out.printf("#%d %d\n",t, cnt);
			}
		}
	}
