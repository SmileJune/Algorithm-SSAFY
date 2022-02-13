package com.ssafy.ehoi;

import java.util.Scanner;

public class Codeup1409 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr =new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(arr[sc.nextInt()-1]);
		sc.close();
	}
}
