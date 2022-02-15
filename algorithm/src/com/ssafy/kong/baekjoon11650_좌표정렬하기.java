package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon11650_좌표정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();        
		int N =  Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a1, int[] a2) {
				if(a1[0] > a2[0]) {
					return 1;
				}
				else if(a1[0] < a2[0]) {
					return -1;
				}
				else {
					return a1[1] - a2[1];
				}
			}
		});
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < 2; ++j) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
