package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10872_팩토리얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int ans = 1;
		for ( int i = 2; i <= num; i++) {
			ans *= i;
		}
		System.out.println(ans);	
	}
}
