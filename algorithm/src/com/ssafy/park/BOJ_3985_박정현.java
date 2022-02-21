package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3985_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())+1];
		int no = Integer.parseInt(br.readLine());
		int max = 0;
		int max2 = 0;
		int idx = 0;
		int idx2 = 0;
		for ( int i = 0; i < no; i++) {
			int cnt = 0;
			int cnt2 = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for ( int j = a; j <= b; j++) {
				cnt2++;
				if (arr[j] == 0) {
					cnt++;
					arr[j] = i+1;
				}
			}
			if ( max < cnt) {
				idx = i+1;
				max = cnt;
			}
			if ( max2 < cnt2) {
				max2=cnt2;
				idx2 = i+1;
			}
		}
		System.out.println(idx2);
		System.out.println(idx);
 	}
}
