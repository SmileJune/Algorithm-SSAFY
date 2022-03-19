package com.ssafy.hwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day11_BOJ_1929_소수구하기 {
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		getPrimeE(N);
	}

	public static int getPrimeE(int n) {
		int cnt = 0;
		boolean[] check = new boolean[n+1];
		
		 for(int i=2;i<=N;i++) {
			 if(!check[i]) {
				 if(i>=M) {
				 System.out.println(i);
				 }
			 }
			 for(int j = i*2; j<=N; j+=i) {
				 check[j] = true;
			 }
		 }
		
		return cnt;
	}
}
