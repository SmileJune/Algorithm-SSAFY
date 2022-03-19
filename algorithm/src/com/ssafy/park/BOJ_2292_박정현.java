package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int temp = 1;
		int cnt = 1;
		while (temp < N) {
			temp += cnt*6;
			cnt++;
		}
		System.out.println(cnt);
	}
}
