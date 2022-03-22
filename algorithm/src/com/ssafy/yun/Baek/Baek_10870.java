package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_10870 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		
		System.out.println(fibo(n));
	}
	static int fibo(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1; 
		}
		
		return fibo(n-1) + fibo(n-2);
	}

}
