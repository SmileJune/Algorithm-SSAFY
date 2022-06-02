package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// stack없이 인덱스로 푼 베스트 답안 속도가 1/4 걸립니다.
public class Day112BOJ9935문자열폭발StackBESTSOL { // 9935 문자열 폭발, BEST Solution
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		char[] arr = br.readLine().toCharArray();
		char[] sol = new char[1000010];
		int lastIdx = arr.length - 1;
		int j = 0, k, q;
		for (char c : str) {
			sol[j] = c;
			if (sol[j] == arr[lastIdx] && j >= lastIdx) {
				k = lastIdx;
				q = j;
				while (k >= 0 && sol[q] == arr[k]) {
					q--;
					k--;
				}
				if (k < 0)
					j = q;
			}
			j++;
		}
		sol[j] = 0;

		if (j == 0) {
			System.out.println("FRULA");
		} else {
			char[] ans = Arrays.copyOfRange(sol, 0, j);
			System.out.println(ans);
		}
	}
}
