package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2851_슈퍼마리오{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] mush = new int[10];
		int sum = 0;
		for(int i = 0; i <10; ++i) {
			mush[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < 10; ++i) {
			sum += mush[i];
			if(sum >= 100) {
				if ( 100 - ( sum-mush[i] ) >= ( sum - 100 ) ) {
					sb.append(sum);
					break;
				}
				else {
					sb.append(sum-mush[i]);
					break;
				}
			}
			if( i == 9 ) 
				sb.append(sum);
		}
		System.out.println(sb);
	}
}