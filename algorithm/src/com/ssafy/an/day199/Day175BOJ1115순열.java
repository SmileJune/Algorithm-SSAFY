package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day175BOJ1115순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;
			cnt++;
			int s = i; 
			while (!v[s]) {
				v[s] = true;
				s = arr[s];
			}
		}
		System.out.println(cnt == 1 ? 0 : cnt);
		br.close();
	}
}
