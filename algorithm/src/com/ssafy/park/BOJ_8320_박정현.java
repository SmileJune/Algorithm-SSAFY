package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8320_박정현 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num+1];
		for ( int i = 1; i < arr.length; i++) {
			arr[i] = 1;
			for ( int j = 2; j <= Math.sqrt(i); j++) {
				if ( i % j == 0) arr[i]++;
			}
			arr[i] += arr[i-1];
		}
		System.out.println(arr[num]);
	}
}
