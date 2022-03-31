package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day52_BOJ_S5_1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		int[] arr = new int[tmp.length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = tmp.charAt(i) - '0';
		}
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		
		sc.close();
	}
}
