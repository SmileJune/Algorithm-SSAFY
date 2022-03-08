package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_5356_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= T; t++) {
			String[] lines = new String[5];
			int max_length = 0;
			for (int i = 0; i < 5; i++) {
				lines[i] = sc.nextLine();
				max_length = Math.max(max_length, lines[i].length());
			}

			char[][] words = new char[5][max_length];
			for (int i = 0; i < 5; i++) {
				char[] line = lines[i].toCharArray();
				for (int j = 0; j < line.length; j++)
					words[i][j] = line[j];
				if (lines[i].length() < max_length) {
					for (int j = lines[i].length(); j < max_length; j++)
						words[i][j] = ' ';
				}
			}
			System.out.printf("#%d ", t);
			for (int i = 0; i < max_length; i++) {
				for (int j = 0; j < 5; j++)
					if (words[j][i] != ' ')
						System.out.print(words[j][i]);
			}
			System.out.println();
		}
	}
}