package com.ssafy.ehoi;

import java.util.Scanner;

public class Day06_BOJ_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int result = a*b*c;
		
		int[] arr = new int[10];
		
		while (result > 0) {
//			int remainder = result%10;
//			arr[remainder]++;
//			result = result/10;
			arr[result%10]++;
			result /= 10;
		}
		
		for (int i=0; i <arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		sc.close();
	}
}
