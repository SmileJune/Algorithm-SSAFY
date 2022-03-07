package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1436 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) { //메모리 초과
		int N = sc.nextInt();
		int[] arr = new int[10000000];
		for (int i = 666; i < arr.length; i++) {
			if ((i + "").contains("666")) {
				arr[i]++;
			}
		}
		int cnt = 0;
		int ans = 0;
		for (int i = 666; i < arr.length; i++) {
			if (arr[i] > 0) {
				cnt++;
			}
			if (cnt == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);

	}

}
