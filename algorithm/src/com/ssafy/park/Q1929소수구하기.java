package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1929소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[b + 1];
		int[] prime = new int[b];
		for (int i = 2; i <= b; i++) {
			if (!arr[i]) {
				for (int j = i + i; j <= b; j += i) {
					arr[j] = true;
				}
			}
		}
		int idx = 0;
		for (int i = 2; i <= b; i++) {
			if (arr[i] != true) {
				prime[idx] = i;
				idx++;
			}
		}
		for (int i : prime) {
			if (i >= a)
				System.out.print(i + "\n");
			if (i == 0)
				break;
		}
	}
}
