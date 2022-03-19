package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3052_박정현 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[42];
		for ( int tc = 1; tc <= 10; tc++) {
			arr[Integer.parseInt(br.readLine()) % 42]++;
		}
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) cnt++;
		}
		System.out.println(cnt);
	}
}
