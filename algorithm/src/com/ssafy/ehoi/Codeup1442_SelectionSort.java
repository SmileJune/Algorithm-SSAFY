package com.ssafy.ehoi;

import java.util.Scanner;

public class Codeup1442_SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[sc.nextInt()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length -1; i++) {
			int minIdx = i;
			// arr[minIdx]보다 더 작은 arr[j] 찾기
			for (int j = i+1; j <arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
		
		for (int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		sc.close();
	}
}
