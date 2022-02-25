package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day17_BOJ_B1_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		
		for (int r = 0; r < R; r++) { // 라운드 반복
			int a = sc.nextInt();
			int[] Acard = new int[a];
			for(int i = 0; i < a; i++) {
				Acard[i] = sc.nextInt();
			} // 라운드마다 A카드
			
			// 카드 내림차순으로 정렬
			sort(Acard);
//			System.out.println(Arrays.toString(Acard));
			
			int b = sc.nextInt();
			int[] Bcard = new int[b];
			for (int i = 0; i < b; i++) {
				Bcard[i] = sc.nextInt();
			} // 라운드마다 B카드
			
			sort(Bcard);
//			System.out.println(Arrays.toString(Bcard));
			
			whoWin(Acard, Bcard);
			
		} // 아 블록 안에서 5번 출력
		
		
		sc.close();
	}
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int maxIdx = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[maxIdx]) {
					maxIdx = j;
				}
			}
			// 스왑
			int tmp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = tmp;
		}
	}
	
	// 왜 무한반복을 도는 것일까..! return을 해주니까 일단 무한반복은 안돌았어 
	public static void whoWin(int[] arr, int[]arr2) {
		int idx = 0;
		while(idx < arr.length && idx < arr2.length) { // 인덱스의 범위가 두 배열의 길이보다 작을 때
			if (arr[idx] > arr2[idx]) {
				System.out.println("A");
				return;
			} else if (arr[idx] < arr2[idx]){
				System.out.println("B");
				return;
			} else {
				idx++;
			}
		} 
		// 여기서부터는 일단 같은 idx끼리는 전부 같다는 거야
		if (arr.length > arr2.length) {
			System.out.println("A");
			return;
		}
		else if (arr.length < arr2.length) {
			System.out.println("B");
			return;
		}
		else System.out.println("D");
	}
}
