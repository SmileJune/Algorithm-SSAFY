package com.ssafy.ehoi;

import java.util.Scanner;
// 숫자 로테이션
public class Codeup1405 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 숫자 n = 배열 길이 
		int n = sc.nextInt();
		int[] arr = new int[n];
		// n개의 숫자를 배열에 담자
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// n번만큼 숫자를 로테이션 하자
		for (int i = 0; i < arr.length; i ++) {
			for (int j = i; j < arr.length + i; j++) {
				System.out.printf("%d ", arr[j % arr.length]);
			}
			System.out.println();
		}
		
		sc.close();
	}
}
