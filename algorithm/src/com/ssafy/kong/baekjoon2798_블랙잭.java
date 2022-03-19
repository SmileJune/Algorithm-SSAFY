package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon2798_블랙잭{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());

		
		int sum = 0;
		int max = 0;
		for(int i = 0; i < n; ++i) {
			for(int j = i+1; j < n; ++j) {
				for(int k = j+1; k < n; ++k) {
					sum = 0;
					sum+= arr[i] + arr[j] + arr[k];
					if( sum > m ) {
						continue;
					} else {
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);
	}
}