package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2292_벌집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if( n == 1 ) {
			System.out.println(1);
		}
		int sum = 0;
		for(int i = 1; i <= n; ++i) {
			if( n > 1+sum && n <= 1+sum+6*i) {
				System.out.println(i+1);
				break;
			}
			sum+=6*i;
		}
	}
}