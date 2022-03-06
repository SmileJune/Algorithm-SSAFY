package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_4047_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		test: for (int t = 1; t <= T; t++) {
			int[] cards = { 13, 13, 13, 13 }; // S, D, H, C 남은 카드 수
			String line = sc.nextLine();
			int cnt = line.length() / 3;
			String[] picked = new String[cnt];
			for (int i = 0; i < cnt; i++) {
				picked[i] = line.substring(0, 3);
				line = line.substring(3);
			}

			for (int i = 0; i < cnt; i++) {
				for (int j = i + 1; j < cnt; j++) {
					if (picked[i].equals(picked[j])) {
						System.out.printf("#%d ERROR\n", t);
						continue test;
					}
				}
			}
			for (int i = 0; i < cnt; i++) {
				if (picked[i].charAt(0) == 'S')
					cards[0]--;
				else if (picked[i].charAt(0) == 'D')
					cards[1]--;
				else if (picked[i].charAt(0) == 'H')
					cards[2]--;
				else if (picked[i].charAt(0) == 'C')
					cards[3]--;
				else
					continue;
			}

			System.out.printf("#%d ", t);
			for (int card : cards)
				System.out.printf("%d ", card);
			System.out.println();
		}
	}
}