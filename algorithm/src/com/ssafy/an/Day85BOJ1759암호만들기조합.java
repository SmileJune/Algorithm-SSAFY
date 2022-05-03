package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day85BOJ1759암호만들기조합 {
	static int N, C;
	static char[] arr, tmp;
	static List<String> ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		arr = br.readLine().replaceAll(" ", "").toCharArray();
		tmp = new char[N];
		ans = new ArrayList<>();
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(toString(ans));
		br.close();
	}

	private static void comb(int idx, int n) {
		if (idx == N) {
			if (check(0, 0))
				ans.add(str(tmp, ""));
			return;
		}
		for (int i = n; i < C; i++) {
			tmp[idx] = arr[i];
			comb(idx + 1, i + 1);
		}
	}

	private static String str(char[] t, String s) {
		for (char c : t)
			s += c;
		return s;
	}

	private static boolean check(int vo, int co) {
		for (char c : tmp) {
			if ("aeiou".contains(c + ""))
				vo++;
			else
				co++;
			if (vo > 0 && co > 1)
				return true;
		}
		return false;
	}

	private static String toString(List<String> a) {
		StringBuilder tt = new StringBuilder();
		for (String s : a)
			tt.append(s + "\n");
		return tt.toString();
	}

}
