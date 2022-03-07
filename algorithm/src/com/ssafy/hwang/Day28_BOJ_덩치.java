package com.ssafy.hwang;

import java.util.Scanner;

public class Day28_BOJ_덩치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i = 0 ; i<N;i++) {
			for(int j = 0 ; j<2;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N; j++) {
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					cnt++;
				}

			}
			if(i==(N-1)) {
				System.out.print(cnt);
				continue;
			}
			System.out.print(cnt+" ");
			
		}
		
	}
}
