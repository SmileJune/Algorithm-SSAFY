package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon8320_직사각형 {
	static 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			int divisor = 0;
			for(int j = 1; j <= i; ++j) {
				if( i % j == 0) {
					divisor++;
				}
			}
			if( divisor % 2 == 1 ) {
				ans += divisor/2 + 1;
			}else
				ans+= divisor/2;
		}
		System.out.println(ans);
	}
	static void other() throws IOException {
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 1;  i<= n; ++i) {
			for(int j = i; i*j <= n; ++j) {
				count++;
			}
		}
		System.out.println(count);
	}
}

