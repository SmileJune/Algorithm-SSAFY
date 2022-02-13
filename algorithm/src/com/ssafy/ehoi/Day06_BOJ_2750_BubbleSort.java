package com.ssafy.ehoi;

import java.util.Scanner;

public class Day06_BOJ_2750_BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i =0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i =0; i <arr.length; i++) {
			for (int j =0; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for (int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
			
		}
		
		
		
		
		
		sc.close();
	}
}
