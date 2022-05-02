package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {
	static String S, T;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		recur(T);
		System.out.println(ans);
	}

	static boolean flag = true;

	static void recur(String t) {
		if (t.length() == S.length()) {
			ans = t.equals(S) ? 1 : 0;
			return;
		}
		// A면 그냥 빼.
		if (t.charAt(t.length() - 1) == 'A')
			recur(t.substring(0, t.length() - 1));
		// B면 빼고 리버스해줘.
		else {
			recur(new StringBuffer().append(t.substring(0, t.length() - 1)).reverse().toString());
		}
	}
}
