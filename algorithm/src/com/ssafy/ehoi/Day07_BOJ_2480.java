package com.ssafy.ehoi;

import java.util.Scanner;

public class Day07_BOJ_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		
		if (i==j &&j==k) {
			System.out.println(10000 + i *1000);
		} else if (i==j || i==k) {
			System.out.println(1000 + i*100);
		} else if (j==k) {
			System.out.println(1000 + j*100);
		} else System.out.println(Math.max(Math.max(i, j), k)*100);
		
		
		
		
		sc.close();
	}
}
