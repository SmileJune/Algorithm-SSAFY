package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int num = 1;
		while(gen(num++) != n) {
			if(num > n) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(num-1);
		
	}
	static int gen(int n) {
		int ans = n;
		while(n > 0) {
			ans += n%10;
			n /= 10;
		}
		return ans;
	}
	
}
