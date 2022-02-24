package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676_백토리얼0의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		while ( num >= 5) {
			cnt += num/5;
			num /= 5;
		}
		System.out.println(cnt);
	}
}
