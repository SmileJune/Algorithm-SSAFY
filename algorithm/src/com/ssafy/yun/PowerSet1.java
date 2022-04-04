package com.ssafy.yun;

import java.util.Arrays;

public class PowerSet1 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i <= 1; i++) {
			arr[0] = i;
			for (int j = 0; j <= 1; j++) {
				arr[1] = j;
				for (int k = 0; k <= 1; k++) {
					arr[2] = k;
					for (int m = 0; m <= 1; m++) {
						arr[3] = m;
						for (int n = 0; n <= 1; n++) {
							arr[4] = n;
							System.out.println(Arrays.toString(arr));
						}
					}
				}
			}
		}

	}

}
