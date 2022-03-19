package com.ssafy.hwang;

import java.util.Scanner;

public class Day35_BOJ_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N : Between 1 AND 1000
		int N = sc.nextInt();
		
		long[] fibo = new long[N+1];
		for(int i = 0; i<=N;i++) {
			if(i<2) {
				fibo[i] = 1;
				continue;
			}
			fibo[i] = (fibo[i-1] + fibo[i-2])%10007;
		}
		 
		
		System.out.println(fibo[N]);
		sc.close();
	}
	
}
