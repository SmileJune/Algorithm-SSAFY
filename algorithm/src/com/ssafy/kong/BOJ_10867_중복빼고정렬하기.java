package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10867_중복빼고정렬하기 {
	static int N;
	static boolean[] isSame;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isSame = new boolean[2002];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		int[] tmp = new int[N];
		int min = 1002;
		for (int i = 0; i < N; ++i) {
			int val = Integer.parseInt(st.nextToken());
			tmp[i] = val;
			if (val < min) {
				min = val;
			}
		}
		boolean flag = true;
		if (min < 0) {
			flag = false;
			setArr(tmp, min, flag);
		} else {
			min = 0;
			setArr(tmp, min, flag);
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for (int i = 0; i < N; ++i) {
			if (arr[i] != -1) {
				sb.append(arr[i]+min).append(" ");
			}
		}
		System.out.println(sb);
	}

	static void setArr(int[] tmp, int min, boolean flag) {
		for (int i = 0; i < N; ++i) {
			if (!flag)
				tmp[i] -= min;
			if (!isSame[tmp[i]])
				arr[i] = tmp[i];else {
					arr[i] = -1;
				}
			isSame[tmp[i]] = true;
		}
	}
}