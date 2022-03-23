package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day44_BOJ_B4_2752 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
}
