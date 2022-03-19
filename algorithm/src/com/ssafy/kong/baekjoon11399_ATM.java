package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon11399_ATM{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		int sum = 0;
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < i; ++j) {
				sum += p[j];
			}
			sum += p[i];
		}
		System.out.println(sum);
	}
}