package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1431_박성현 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			int N = sc.nextInt();
			String[] words = new String[N];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				words[i] = sc.nextLine();
			}
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int idx = i;
				int idx_cnt = 0;
				for (char c : words[i].toCharArray()) {
					if (c >= 48 && c <= 57)
						idx_cnt += c - '0';
				}
				int length = words[i].length();
				for (int j = i + 1; j < N; j++) {
					if (length > words[j].length()) {
						for (char c : words[j].toCharArray()) {
							if (c >= 48 && c <= 57)
								cnt += c - '0';
						}
						idx = j;
						length = words[j].length();
						idx_cnt = cnt;
						cnt = 0;
						continue;
					}

					if (length == words[j].length()) {
						for (char c : words[j].toCharArray()) {
							if (c >= 48 && c <= 57)
								cnt += c - '0';
						}
						if (idx_cnt > cnt) {
							idx = j;
							idx_cnt = cnt;
						} else if (idx_cnt == cnt) {
							for (int k = 0; k < length; k++) {
								if (words[idx].toCharArray()[k] == words[j].toCharArray()[k]) {
									continue;
								} else if (words[idx].toCharArray()[k] > words[j].toCharArray()[k]) {
									idx = j;
									idx_cnt = cnt;
									break;
								}
								else {
									break;
								}
							}
						}
						cnt = 0;
					}
				}
				String temp = words[i];
				words[i] = words[idx];
				words[idx] = temp;
			}
			for (String word : words)
				System.out.println(word);

		}
	}