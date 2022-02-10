package com.ssafy.ehoi;

import java.util.Scanner;

public class Codeup1441_BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
int[] arr = new int[sc.nextInt()];
		
		for (int i =0; i <arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// 버블 정렬 시작
		for(int i = arr.length-1; i >=1; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}		
		
		
		sc.close();
	}
}
