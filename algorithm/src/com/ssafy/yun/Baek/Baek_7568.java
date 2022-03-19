package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_7568 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			int biggerNum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][0] >= arr[j][0]) {
					continue;
				}
				if (arr[i][1] >= arr[j][1]) {
					continue;
				}
				biggerNum++;
			}
			System.out.println(biggerNum+1);

		}
	}

}
