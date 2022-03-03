package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1316 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int tc = 1; tc <= T; tc++) {
			if (isGroupWord(br.readLine()))
				cnt++;
		}
		System.out.println(cnt);

	}

	public static boolean isGroupWord(String str) {
		char pivot = '0';
		boolean[] visited = new boolean['z' - 'a' + 1];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (pivot != ch) {
				if (visited[ch - 'a'] == true) {
					return false;
				}

				visited[ch - 'a'] = true;
				pivot = ch;

			} else {
				continue;
			}
		}

		return true;
	}

}
