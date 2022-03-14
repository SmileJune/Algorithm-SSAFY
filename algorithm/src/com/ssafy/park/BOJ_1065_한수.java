package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065_한수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			String str = Integer.toString(i);
			int idx = 0;
			int temp = 0;
			if (str.length() == 1) cnt++;
			else {
				cnt++;
				while (str.length() > idx+1) {
					if (idx > 0 && str.charAt(idx) - str.charAt(idx+1) != temp) {
						cnt--;
						break;
					} else {		
						temp = str.charAt(idx) - str.charAt(idx+1);
						idx++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
