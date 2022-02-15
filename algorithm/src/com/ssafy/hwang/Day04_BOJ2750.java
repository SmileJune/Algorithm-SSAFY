package com.ssafy.hwang;
/*
 * [BOJ 2750 수 정렬하기 B1]
 * 
 * 정렬문제
 * N개의 숫자가 주어졌을 때, 오름차순으로 정렬하는 문제
 * 
 * input:   N	: 주어지는 숫자의 갯수
 			n	: n개의 숫자가 줄바꿈하며 입력됨.  
 * output:  입력숫자를 하나씩 줄바꿈하며 오름차순으로 출력.
 */

import java.util.Scanner;


public class Day04_BOJ2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tmp =0;
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		for(int i =0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
