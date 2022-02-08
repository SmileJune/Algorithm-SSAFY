package com.ssafy.park;

import java.util.Arrays;
import java.util.Scanner;

public class day01S2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        sc.nextLine();
		int[] arr = new int[num];
		for (int i=0;i<num;i++) {
			arr[i] = sc.nextInt();
            sc.nextLine();
		}
		Arrays.sort(arr);
		for (int i =0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
