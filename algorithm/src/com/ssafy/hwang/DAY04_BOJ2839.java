package com.ssafy.hwang;

/*
 * [BOJ 2839 설탕 배달 (B1)]
 * 
 *  그리디 알고리즘
 *  n이 주어질때, n =  5*i + 3*j 식이 가능하다면 i+j가 최소가 되는 값을 출력,
 *  불가능하다면  -1을 출력하는 문제.
 */

import java.util.Scanner;

public class DAY04_BOJ2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		sc.close();
		
		if(n<3 || n==4||n==7) {
			System.out.println(-1);
		}
		else if(n%5 ==0) {
			System.out.println(n/5);
		}
		else if(n%5 ==1 || n%5==3) {
			System.out.println((n/5)+1);
		}
		else if(n%5 ==2 || n%5==4) {
			System.out.println((n/5)+2);
		}
	}
}
