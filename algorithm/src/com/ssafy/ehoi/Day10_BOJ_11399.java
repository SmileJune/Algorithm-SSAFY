package com.ssafy.ehoi;

import java.util.Scanner;

public class Day10_BOJ_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		
		int[] time = new int[N]; // 걸리는 시간 배열
		
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		} // 걸리는 시간 배열 생성
		
		// 오름차순 정렬
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			int minIdx = i; // 최솟값 인덱스가 늘 i로 설정이 되어야 하는 구나
			for (int j = i+1; j < N; j++) {
				if (time[minIdx] > time[j]) {
					minIdx = j;
				}
			}
			tmp = time[minIdx];
			time[minIdx] = time[i];
			time[i] = tmp;
		}
		
		int[] sumTime = new int[N];
		// 정렬된 배열에서 누적합 배열을 만들자
		sumTime[0] = time[0];
		for (int i = 1; i < N; i++) {
			sumTime[i] = sumTime[i-1] + time[i];
		}
		
		// 그리고 누적합 배열의 합을 구하자
		int sum = 0;
		for (int i = 0; i <N; i++) {
			sum += sumTime[i];
		}
		
		System.out.println(sum);
		
		
		sc.close();
	}
}
