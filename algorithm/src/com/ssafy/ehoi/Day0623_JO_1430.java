package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0623_JO_1430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int res = a * b * c;
		String resStr = String.valueOf(res);
		int[] arr = new int[10];
		
		for (int i = 0; i < resStr.length(); i++) {
			char ch = resStr.charAt(i);
			arr[Integer.parseInt(ch+"")]++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}