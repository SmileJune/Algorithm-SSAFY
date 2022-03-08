package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748_수이어쓰기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int temp = N;
		while (true) {
			if ( temp / 10 == 0) break;
			temp = temp / 10;
			cnt++;
		}
		int sum = 0;
		for (int i = 0; i < cnt-1; i++) {
			sum += 9 * Math.pow(10, i)*(i+1);
		}
		sum += cnt * (N-Math.pow(10, cnt-1)+1);
		System.out.println(sum);
	}
}
