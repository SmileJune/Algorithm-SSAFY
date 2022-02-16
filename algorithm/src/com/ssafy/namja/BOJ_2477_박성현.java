package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2477_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int[] areaArr = new int[6];
		int[] lengthArr = new int[7]; 
		
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			lengthArr[i] = sc.nextInt();
		}
		lengthArr[6] = lengthArr[0];
		
		int maxArea = 0;
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			areaArr[i] = lengthArr[i]*lengthArr[i+1];
			maxArea = Math.max(maxArea, areaArr[i]);
			sum += areaArr[i];
		}
		
		System.out.println((sum-2*maxArea)*K);
		sc.close();
	}
}
