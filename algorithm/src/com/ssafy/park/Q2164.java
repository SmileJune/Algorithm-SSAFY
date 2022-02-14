package com.ssafy.park;

import java.util.Scanner;

public class Q2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = i+1;
		}
		int cnt = 0;
		for (int j = 1; j <num-1; j++) {
			int temp = arr[1];
			for (int i = 2; i < num; i++) {
				arr[i-2] = arr[i];
			}
			arr[num-1-j] = temp;
			arr[num-1] = 0;
		} System.out.println(arr[1]);
	}
}
