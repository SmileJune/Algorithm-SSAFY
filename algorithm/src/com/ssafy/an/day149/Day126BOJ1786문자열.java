package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day126BOJ1786문자열 { // 1786 찾기
	static int N, M;
	static int[] pi;
	static String str, ptn;
	static List<Integer> list;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		ptn = br.readLine();
		list = new ArrayList<Integer>();

		pi = getPi(ptn);
		kmp();

		for (int ele : list)
			sb.append(ele).append(" ");

		System.out.println(list.size());
		System.out.println(sb.toString());
		br.close();
	}

	static void kmp() {
		int j = 0;
		N = str.length();
		M = ptn.length();

		for (int i = 0; i < N; i++) {
			while (j > 0 && str.charAt(i) != ptn.charAt(j))
				j = pi[j - 1];

			if (str.charAt(i) == ptn.charAt(j)) {
				if (j + 1 == M) {
					list.add(i - M + 2);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	static int[] getPi(String str) {
		int j = 0;
		int n = str.length();
		int[] pi = new int[n];

		for (int i = 1; i < n; i++) {
			while (j > 0 && str.charAt(j) != str.charAt(i))
				j = pi[j - 1];

			if (str.charAt(j) == str.charAt(i))
				pi[i] = ++j;
		}

		return pi;
	}
}
