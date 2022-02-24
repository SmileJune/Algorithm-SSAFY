package com.ssafy.ehoi;

import java.util.Scanner;

public class Day17_JO_1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		} // 패리티 행렬 입력 완료

		boolean flag = true; // 일단 패리티하다고 보고
		int changeRow= 0, changeCol = 0;
		int rowCnt = 0;
		for (int i = 0; i < arr.length; i++) { // 행부터 보고
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				sum += arr[i][j];
			} // 한 줄에 대한 합을 다 더했다
			if (sum % 2 == 0)
				continue; // 짝수합이라면 다음 행 보러 가시고
			else {
				flag = false;
				rowCnt++;
				if (rowCnt >= 2) {
//					System.out.println("Corrupt");
					break;
				}
				changeRow = i;
			}
		}
		int colCnt = 0;
		for (int j = 0; j < arr.length; j++) { // 열에 대한 합
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i][j];
			} // 한 줄에 대한 합을 다 더했다
			if (sum % 2 == 0)
				continue; // 짝수합이라면 다음 행 보러 가시고
			else {
				flag = false;
				colCnt++;
				if (colCnt >= 2) {
//					System.out.println("Corrupt");
					break;
				}
				changeCol = j;
			}
		}
		if (!flag && rowCnt==1 && colCnt==1) { // parrity가 아니고 
			System.out.printf("Change bit (%d,%d)", changeRow+1, changeCol+1);
		}
		if(!flag && (rowCnt>=2 || colCnt>=2)) {
			System.out.println("Corrupt");
		}
		
		if (flag) 
		System.out.println("OK");

		sc.close();
	}
}
