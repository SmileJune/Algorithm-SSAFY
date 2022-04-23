package com.ssafy.hwang;

import java.util.*;
public class Day75_BOJ_정수삼각형 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
        // 데이터 입력
		int n = in.nextInt();
		int arr[][] = new int [n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
        // 1번 행부터
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j-1>=0)
					arr[i][j]+=Math.max(arr[i-1][j], arr[i-1][j-1]);
				else
					arr[i][j]+=arr[i-1][j];
			}			
		}
		
		int max = Integer.MIN_VALUE;
		
        // 마지막행에서 취할 수 있는 최댓값을 가져오면 된다.
		for(int i=0;i<n;i++) {
			if(max<arr[n-1][i]) 
				max = arr[n-1][i];
		}
		
		System.out.println(max);
	}
}
