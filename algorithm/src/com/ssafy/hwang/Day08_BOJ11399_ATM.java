package com.ssafy.hwang;
/*
 * [BOJ 11399 ATM S3]
 * 오름차순 정렬 후 값의 누적합을 구하는 문제. 
 */
import java.util.Scanner;

public class Day08_BOJ11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum =0;
		int len = sc.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		insertion_sort(arr);
		
		for(int i =1;i<arr.length;i++) {
			arr[i] = arr[i-1]+arr[i];
			}
		for(int i=0;i<arr.length;i++) {
		sum += arr[i];
		}
		System.out.println(sum);
		sc.close();
	}
	
	static void insertion_sort(int[] arr) {
//		insertion sort
		for (int i = 1; i < arr.length; i++) {
			int j;
			int temp = arr[i];
			// 조건 안맞을때 break 안해주면 0번째 인덱스를 덮어버림.
			// for문 조건문에 넣어서 조건안맞으면 바로 break되게 만들기 쌉가능.
			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
					arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}
	
}
