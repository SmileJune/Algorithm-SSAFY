package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1213 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws IOException {
		int cnt = 0;
		br.readLine();
		char[] target = br.readLine().toCharArray();
		char[] str = br.readLine().toCharArray();

		for (int i = 0; i < str.length - target.length + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < target.length; j++) {
				if (target[j] != str[i + j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}

		return cnt;
	}

}
