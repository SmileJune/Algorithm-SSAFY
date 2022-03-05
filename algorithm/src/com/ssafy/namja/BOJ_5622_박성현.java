package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_5622_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();
		char[] w = word.toCharArray();
		String[] ws = new String[w.length];
		for (int i = 0; i < w.length; i++) {
			ws[i] = w[i] + "";
		}
		String[] words = { "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
		int total = 0;

		for (String ch : ws) {
			for (int i = 0; i < words.length; i++)
				if (words[i].contains(ch))
					total += (i + 3);
		}

		System.out.println(total);
	}
}
