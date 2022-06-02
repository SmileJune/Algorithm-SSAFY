package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day27BOJ3033Fail가장긴문자열시간초과 { // 3033 가장 긴 문자열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int cnt = 0;
		for (int i = 0; i < L - 1; i++) {
			for (int j = i + 1; j < L; j++) {
				int tmp = 0;
				if (arr[i] == arr[j]) {
					tmp++;
					int idx = i + 1;
					int jdx = j + 1;
					while (true) {
						if (jdx == L)
							break;
						if (arr[idx] == arr[jdx])
							tmp++;
						else
							break;
						idx++;
						jdx++;
					}
				}
				if (tmp > cnt)
					cnt = tmp;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
