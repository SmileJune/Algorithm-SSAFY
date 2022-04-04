package com.ssafy.yun;

public class PowerSet2 {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < (1 << 8); i++) {
			for (int j = 0; j < 8; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}

	}

}
