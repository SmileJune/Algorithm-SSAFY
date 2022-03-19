package com.ssafy.kong;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class baekjoon10816_숫자카드2 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());  
			// upperBound와 lowerBound의 차이 값을 구한다.
			sb.append(upper_bound(key) - lower_bound(key)).append(" ");
		}
		System.out.println(sb.toString());
	}
 
	static int lower_bound(int num) {
		int start = 0, last = arr.length, mid;
		while(start<last) {
			mid = start + (last-start)/2;
			if(num <= arr[mid]) {
				last = mid;
			}
			else {
				start = mid+1;
			}
		}
		return start;
	}
	static int upper_bound(int num) {
		int start = 0, last = arr.length, mid;
		while(start < last) {
			mid = start + (last-start)/2;
			if(num >=arr[mid])
				start = mid +1;
			else
				last = mid;
		}
		return start;
	}
}