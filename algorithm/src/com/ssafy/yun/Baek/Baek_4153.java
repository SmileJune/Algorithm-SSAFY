package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_4153 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			int[] arr = new int[3];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] == 0) {
					return;
				}
			}

			Arrays.sort(arr);
			
			if (Math.pow(arr[2], 2) == Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}

	}

}
