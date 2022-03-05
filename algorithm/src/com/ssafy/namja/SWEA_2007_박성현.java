package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_2007_박성현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= T; t++) {
			String line = sc.nextLine();
			int num = 0;
			for (int i = 1; i <= line.length(); i++) {
				int j = 0;
				StringBuilder sb1 = new StringBuilder("");
				StringBuilder sb2 = new StringBuilder("");

				while (j < i) {
					sb1.append(line.charAt(j));
					j++;
				}
				while (j < 2 * i) {
					sb2.append(line.charAt(j));
					j++;
				}
				if (sb1.toString().equals(sb2.toString())) {
					num = i;
					break;
				}
			}
			System.out.printf("#%d %d\n", t, num);
		}
	}
}