package com.ssafy.woong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B11651 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] arr = new int[T][2];
		
		for(int tc = 0; tc < T; tc++) {
			arr[tc][0] = sc.nextInt();
			arr[tc][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] arg0, int[] arg1) {
				if(arg0[1] == arg1[1]) {
					return arg0[0] - arg1[0];
				}
				else {
					return arg0[1] - arg1[1];
				}
			}
			
		});
		
		for(int tc = 0; tc < T; tc++) {
			System.out.println(arr[tc][0]+" "+arr[tc][1]);
		}
		
		
	}
}
