package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {
	static int[] num;
	static char[] ch;
	static boolean[] visited;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		ch = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; ++i) {
			ch[i] = st.nextToken().charAt(0);
		}
		num = new int[k + 1];
		for (int i = 0; i <= k; ++i) {
			num[i] = 9 - i;
		}
		recur();
		for (int i = 0; i <= k; ++i) {
			System.out.print(num[i]);
		}
		System.out.println();
		for (int i = 0; i <= k; ++i) {
			num[i] = i;
		}
		recur();
		for (int i = 0; i <= k; ++i) {
			System.out.print(num[i]);
		}
	}

	static int idx = 0;

	static void recur() {
		boolean flag = true;
		for (int i = 0; i < k; ++i) {
			if (ch[i] == '<') {
				if (num[i] > num[i+1]) {
					swap(i, i+1);
					flag = false;
				}
			}
			if (ch[i] == '>') {
				if (num[i] < num[i + 1]) {
					swap(i, i+1);
					flag = false;
				}
			}
		}
		if (flag) {
			return;
		}
		recur();
	}

	static void swap(int i, int j) {
		int tmp = 0;
		tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}
