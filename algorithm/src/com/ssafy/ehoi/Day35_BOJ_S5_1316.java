package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day35_BOJ_S5_1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int groupWord = 0;
		outer : for (int i = 0; i < n; i++) {
			String word = br.readLine();
			// 이미 나왔는지 체크하는 배열
			boolean[] already = new boolean['z' - 'a' + 1];
			for (int j = 1; j < word.length(); j++) {
				char now = word.charAt(j);
				char pre = word.charAt(j-1);
				if (already[now - 'a']) { // 이미 나온적이 있다면
					continue outer; // 다음 턴으로 가 
				}
				// 나온적이 없다면 검사
				if (now != pre) {
					already[pre-'a'] = true; // 전에꺼는 나왔다고 처리
				}
			}
			// 그룹단어인 것
			groupWord++;

		}
		System.out.println(groupWord);
	}
}
