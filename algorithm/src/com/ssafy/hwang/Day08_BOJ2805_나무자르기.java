package com.ssafy.hwang;
/*
 * [BOJ2805 나무자르기 S3]
 *  Bynary Search
 *  주어진 나무들의 길이에서 얼마만큼의 동일한 높이에서 잘랐을 때 
 *  목표치 이상 중 최솟값을 구할 수 있는지 묻는 문제
 * 	
 *  조건문을 잘 생각해야한다. 
 *  
 */
import java.util.Scanner;

public class Day08_BOJ2805_나무자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int target = sc.nextInt();
		
		int start = 0;
		int end = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			end = Math.max(end, arr[i]);
		}
		int mid = 0;
		while (start <= end) {

			long result = 0;
			mid= (start + end) / 2;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] - mid > 0)
					result += (arr[i] - mid);
			}

			if (result < target) {
				end = mid-1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(start-1);
		sc.close();
	}
}
