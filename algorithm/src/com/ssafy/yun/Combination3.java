package com.ssafy.yun;

import java.util.Arrays;

public class Combination3 {

	static int[] arr, sel;
	static int n, r;

	public static void main(String[] args) {
		n = 5;
		r = 3;
		arr = new int[] { 1, 2, 3, 4, 5 };
		sel = new int[r];
		
		for(int i=0; i<3; i++) {
			for(int j=i+1; j<4; j++) {
				for(int k=j+1; k<5; k++) {
					System.out.print(arr[i]+", ");
					System.out.print(arr[j]+", ");
					System.out.println(arr[k]);
				}
			}
		}

	}

}
