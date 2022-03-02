package com.ssafy.ehoi;

import java.util.Scanner;

public class Day23_BOJ_B5_2845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int person = sc.nextInt()*sc.nextInt();
		for (int i = 0; i < 5; i++) {
			System.out.print(sc.nextInt()-person+" ");
		}
		
		sc.close();
	}
}
