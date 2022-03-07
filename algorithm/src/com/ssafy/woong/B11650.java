package com.ssafy.woong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[][] arr = new int[t][2];
		
		for(int i = 0; i < t; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
			
		});
		
		for(int[] num : arr) {
			System.out.println(num[0] + " " + num[1]);
		}
	}

}
