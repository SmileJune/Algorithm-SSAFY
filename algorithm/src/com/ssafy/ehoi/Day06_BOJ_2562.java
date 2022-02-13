package com.ssafy.ehoi;

import java.util.Scanner;

public class Day06_BOJ_2562 {
// 배열을 이용하자
// 최대값인 arr[i]와 i를 출력하면 되겠다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		for (int i = 0; i <9; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = arr[0];
		int maxIdx = 0;
		for (int i = 0; i <9; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		
		System.out.println(max);
		// 아 인덱스가 아니라 몇 번째!니까 +1
		System.out.println(maxIdx+1);
		
		sc.close();
	}
}
