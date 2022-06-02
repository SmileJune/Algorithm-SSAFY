package com.ssafy.an.day049;

import java.util.Scanner;

public class Day09BOJ3985롤케이크 { // 3985
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0; // 희망 최고
		int maxSum = 0; // 실제 최고
		int p1 = 0; // 사람 번호 계산시 + 1
		int p2 = 0;

		int L = sc.nextInt();
		int N = sc.nextInt();

		int arr[] = new int[L];
		for (int i = 0; i < N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			int sum = 0;
			if ((K - P) > max) {
				max = (K - P);
				p1 = i + 1;
			}
			for (int j = P - 1; j < K; j++) {
				if (arr[j] == 0) { // 0이 아닐때만 숫자 부여
					arr[j] = (i + 1);
					sum++; // 결국 자기 숫자가 배열에 많이 들어가야 함
				} 
			}
			if (sum > maxSum) {
				p2 = (i + 1);
				maxSum = sum;
			} // 같으면 먼저 반영된 사람이기때문에 = 미포함
		}
		System.out.println(p1);
		System.out.println(p2);
		sc.close();
	}
}