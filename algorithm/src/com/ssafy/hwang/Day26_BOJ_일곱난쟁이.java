package com.ssafy.hwang;

import java.util.Arrays;
import java.util.Scanner;

public class Day26_BOJ_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] height = new int[9];
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		Arrays.sort(height);
		int temp1 = 0;
		int temp2 = 0;
		outer: for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (sum - (height[i] + height[j]) == 100) {
					temp1 = i;
					temp2 = j;
					break outer;
				}
			}
		}
		for (int i = 0; i < height.length; i++) {
			if (i == temp1 || i == temp2)
				continue;
			System.out.println(height[i]);
		}

	}
}
