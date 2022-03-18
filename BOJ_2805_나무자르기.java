package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.valueOf(st.nextToken()); // 나무의 수
		int M = Integer.valueOf(st.nextToken()); // 최대 나무길이
		int max = Integer.MIN_VALUE;
		Integer[] trees = new Integer[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			trees[i] = Integer.valueOf(st.nextToken());
			if(trees[i] > max) max = trees[i];
		}

		int start = 0; 
		int end = max; 
		int ans = 0;

		while(start<=end) {
			int mid = (start+end) / 2; 
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(trees[i] > mid) {
					sum += trees[i] - mid;
				}
			}

			if(sum >= M) {
				start = mid+1;
				ans = mid;
			}else {
				end = mid-1;
			}

		}

		System.out.println(ans);
	}
}