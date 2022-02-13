package com.ssafy.kong;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1920_수찾기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i = 0; i < N; ++i) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int M = sc.nextInt();
		int low = 0;
	    int high = N - 1;
	    int mid;
	    for(int i = 0; i < M; ++i) {
			int target = sc.nextInt();
			outer : while( low <= high ) {
				mid = (low + high) / 2;
				if (A[mid] == target) {
		            System.out.println( mid ); 
		            break outer;
				}
				else if (A[mid] > target)
			            high = mid - 1;
			        else
			            low = mid + 1;
			}
	    }
	}
}
