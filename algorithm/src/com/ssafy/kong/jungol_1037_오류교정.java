package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1037_오류교정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][n + 1];
		StringTokenizer st;
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = true;
		int errorI = -1;
		int errorJ = -1;
		int cnt = 0;
		for (int i = 1; i <= n; ++i) {
			int sumC = 0;
			int sumR = 0;
			for (int j = 1; j <= n; ++j) {
				sumR += arr[i][j];
				sumC += arr[j][i];
			}
			if (sumR % 2 != 0) {
				// 이러면 i행에서 문제가 발생한 것!
				errorI = i;
				flag = false;
				cnt++;
			}
			if (sumC % 2 != 0) {
				// 이러면 i열에서 문제가 발생한 것!!
				errorJ = i;
				cnt++;
				flag = false;
			}
		}
		if (flag)
			System.out.println("OK");
		else if (cnt == 2 && errorI > 0 && errorJ > 0) {
			System.out.println("Change bit (" + errorI + "," + errorJ + ")");
		} else
			System.out.println("Corrupt");
	}
}