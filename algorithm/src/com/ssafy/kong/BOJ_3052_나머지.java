package com.ssafy.BOJ_BZ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3052_나머지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] remain = new boolean[42];
		int[] arr = new int[10];
		for(int i = 0; i < 10; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			remain[arr[i]%42] = true;
		}
		int ans = 0;
		for(int i = 0; i < 42; ++i) {
			if( remain[i] )
				ans++;
		}
		System.out.println(ans);
	}
}