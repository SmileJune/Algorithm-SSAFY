package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day15_BOJ_S5_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int cnt = 0; // 몇 개의 알파벳인지

		/* 인덱스도 고려하기 */
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);

			if (ch == 'c' && i + 1 < len) { 
				// c로 시작 + 그 다음 자리까지 봐야 하니까 i + 1도 문자열 범위 안에 있어야 해
				if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')
					i++;
			} else if (ch == 'd' && i + 1 < len) {
				if (str.charAt(i + 1) == 'z' && i + 2 < len) { // dz= 는 2칸 뒤까지 봐야하니까
					if (str.charAt(i + 2) == '=')
						i = i + 2;

				} else if (str.charAt(i + 1) == '-')
					i++;

			} else if ((ch == 'l' || ch == 'n') && i + 1 < len) {
				if (str.charAt(i + 1) == 'j')
					i++;
			} else if ((ch == 's' || ch == 'z') && i + 1 < len) {
				if (str.charAt(i + 1) == '=')
					i++;
			}
			cnt++;
		}
		System.out.println(cnt);

	}
}
