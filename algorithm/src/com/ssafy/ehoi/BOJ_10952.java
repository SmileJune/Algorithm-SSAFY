package com.ssafy.ehoi;

import java.util.Scanner;

public class BOJ_10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력으로 0이 들어오면 그만두게 만들어야 할 거 같은데
		
		while(sc.hasNextInt()) {
			
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(a+b);
		
		}
		
		
		sc.close();
	}
}
