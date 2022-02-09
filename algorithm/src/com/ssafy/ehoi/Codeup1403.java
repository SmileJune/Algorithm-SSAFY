package com.ssafy.ehoi;

import java.util.Scanner;

public class Codeup1403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[sc.nextInt()];
		
		for (int i = 0; i < arr.length; i ++) {
			arr[i] = sc.nextInt();
			
		}
		
		for (int j = 0; j < 2; j ++) {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}			
		}
				
		sc.close();
	}
}
