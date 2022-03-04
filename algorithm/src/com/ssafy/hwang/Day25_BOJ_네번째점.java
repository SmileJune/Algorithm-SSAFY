package com.ssafy.hwang;

import java.util.Scanner;

public class Day25_BOJ_네번째점 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] arrX = new int[1001];
		int[] arrY = new int[1001];
		for (int i = 0; i < 3; i++) {
			arrX[sc.nextInt()] ++;
			arrY[sc.nextInt()] ++;
		}
		for(int i=0;i<1001;i++) {
			if(arrX[i]==1) {
				sb.append(i+" ");
				break;
			}
		}
		for(int i=0;i<1001;i++) {
			if(arrY[i]==1) {
				sb.append(i);
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
