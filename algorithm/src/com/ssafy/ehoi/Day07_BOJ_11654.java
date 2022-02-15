package com.ssafy.ehoi;

import java.util.Scanner;

public class Day07_BOJ_11654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// sc로 받으면 String 이라서 문자로 가져오기 위해 charAt하고 그걸 int로 형변환
		int a = (int)sc.next().charAt(0);
		
		System.out.println(a);
		
		sc.close();
	}
}
