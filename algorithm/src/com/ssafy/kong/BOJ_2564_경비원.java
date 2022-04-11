package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = pint(st.nextToken());
		int m = pint(st.nextToken());

		int[] map = new int[(n + m) * 2];
		int store = pint(br.readLine());
		int pos = 0;
		int totalCost = 0;
		int totalLen = (n + m) * 2;

		for (int i = 0; i <= store; i++) {
			int temp = 0;
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "1":// 북쪽
				temp = pint(st.nextToken());
				break;
			case "2":// 남쪽
				temp = n + m + n - pint(st.nextToken());
				break;
			case "3":// 서쪽
				temp = (n + m) * 2 - pint(st.nextToken());
				break;
			case "4":// 동쪽
				temp = n + pint(st.nextToken());
				break;
			default:
				break;
			}
			if (i == store)
				pos = temp; 
			map[temp] = 1;
		}
		for (int i = 1; i < totalLen; i++) {
			if (pos + i == totalLen)
				pos = -i;
			if (map[pos + i] == 1) {
				totalCost += Math.min(i, totalLen - i);
			}
		}
		System.out.println(totalCost);
	}

	static int pint(String s) {
		return Integer.parseInt(s);
	}
}