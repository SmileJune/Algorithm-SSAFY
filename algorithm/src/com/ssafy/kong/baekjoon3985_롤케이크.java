package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon3985_롤케이크{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[][] guest = new int[N][2];
		boolean[] cake = new boolean[L+1];
		StringTokenizer st;
		int max_hope = 0;
		int max_get = 0;
		int ans1 = 0;
		int ans2 = 0;
		for(int i = 0; i < N; ++i) {
			int get = 0;
			st = new StringTokenizer(br.readLine());
			guest[i][0] = Integer.parseInt(st.nextToken());
			guest[i][1] = Integer.parseInt(st.nextToken());
			int hope = guest[i][1] - guest[i][0];
			if(max_hope < hope) {
				max_hope = hope;
				ans1 = i;
			}
			for(int j = guest[i][0]; j <= guest[i][1]; ++j) {
				if( !cake[j] ) {
					cake[j] = true;
					get++;
				}
				else {
					continue;
				}
			}
			if( max_get < get ) {
				max_get = get;
				ans2 = i;
			}
		}
		System.out.println(ans1+1);
		System.out.println(ans2+1);
	}
}