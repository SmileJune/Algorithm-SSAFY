package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1316_그룹단어체커 {
	static List<Character> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			list = new ArrayList<>();
			String str = br.readLine();
			if (check(str))
				ans++;
		}
		System.out.println(ans);
	}

	public static boolean check(String str) {
		char temp = '0';
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == temp)
				continue;
			for (int j = 0; j < list.size(); j++) {
				if (str.charAt(i) == list.get(j))
					return false;
			}
			list.add(str.charAt(i));
			temp = str.charAt(i);
		}
		return true;
	}
}
