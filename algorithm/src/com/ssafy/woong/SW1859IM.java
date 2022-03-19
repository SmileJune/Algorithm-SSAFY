package com.ssafy.woong;

import java.util.Scanner;

public class SW1859IM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] prices = new int[n];
			
			int max = 0;
			for(int i = 0 ; i < n; i++) {
				prices[i] = sc.nextInt();
				if(prices[i] > max) {
					max = prices[i];
				}
			}
			
			long sum = 0;
			int idx = 0, i = 0;
			int cnt = 0;
			while(i < n) {
				for(; i < n; i++) {
					if(prices[i] == max) {
						sum += max * (cnt);
						prices[i] = 0;
						max = 0;
						cnt = 0;
						idx = i;
						break;
					}
					sum -= prices[i];
					cnt++;
					prices[i] = 0;
				}
				
				for(; i < n; i++) {
					if(max < prices[i]) {
						max = prices[i];
					}
				}
				i = idx + 1;
				
			}
			
			System.out.printf("#%d %d\n",tc, sum);
		}
	}
}
