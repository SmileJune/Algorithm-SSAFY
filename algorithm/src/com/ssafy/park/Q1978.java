package com.ssafy.park;

import java.util.Scanner;

public class Q1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int num = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[num];
		String str = sc.nextLine();
		String[] strarr = str.split(" ");
		for (int i = 0; i<num; i++) {
			arr[i] = Integer.parseInt(strarr[i]);
		}
		System.out.println(prime(arr));
	}
	
	public static int prime(int[] arr) {
		int cnt = 0;
		for (int i = 0; i< arr.length; i++) {
			int temp = 0;
			if ( arr[i] == 1) continue;
			for (int j=2; j <= arr[i]; j++) {
				if ( arr[i] % j == 0) temp++;
			}
			if (temp == 1) cnt++;
		}
		return cnt;
	}
}
