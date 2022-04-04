package com.ssafy.yun;

import java.util.Arrays;

public class Permutation1 {

	static int[] arr, sel;

	public static void main(String[] args) {
		arr = new int[] { 1, 2, 3 };
		sel = new int[3];

		for (int i = 0; i < arr.length; i++) {
			sel[0] = arr[i];
			for (int j = 0; j < arr.length; j++) {
				sel[1] = arr[j];
				if (sel[0] == sel[1]) {
					continue;
				}
				for (int k = 0; k < arr.length; k++) {
					sel[2] = arr[k];
					if (sel[0] == sel[2] || sel[1] == sel[2]) {
						continue;
					}
					System.out.println(Arrays.toString(sel));
				}
			}
		}

	}

}
