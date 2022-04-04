package com.ssafy.namja;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759_박성현 {
	static int L;
	static int C;
	static String[] words;
	static String[] pw;
	static String mother = "aeiou";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		C = sc.nextInt();
		
		words = new String[C];
		pw = new String[L];
		for (int i = 0; i < C; i++)
			words[i] = sc.next();
		Arrays.sort(words);
		comb(0,0);
	}
	
	static void comb(int idx, int sidx) {
		if (sidx == L) {
			StringBuffer pass = new StringBuffer("");
			for (String s : pw)
				pass.append(s);
			int m = 0;	// 모음 갯수
			int c = 0;	// 자음 갯수
			for (int i = 0; i < pass.length(); i++) {
				if (mother.contains(pass.charAt(i) + ""))
					m++;
				else
					c++;
			}
			if (m >= 1 && c >= 2)
				System.out.println(pass);
			return;
		}
		if (idx == C) {
			return;
		}
		pw[sidx] = words[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}