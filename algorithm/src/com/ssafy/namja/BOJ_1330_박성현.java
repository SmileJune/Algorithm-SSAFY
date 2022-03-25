package com.ssafy.namja;
import java.util.Scanner;

public class BOJ_1330_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(A > B ? ">" : A < B ? "<" : "==");
	}
}