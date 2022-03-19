package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[M+1];
		arr[0] = arr[1] = true;
		for(int i = 2; i * i <= M; ++i) {
			if(arr[i]) continue;
			for(int j = i * i; j <= M; j+=i) {
				arr[j] = true;
			}
		}
		for(int i = N; i <= M; ++i) {
			if(!arr[i])
			System.out.println(i);
		}
	}
}