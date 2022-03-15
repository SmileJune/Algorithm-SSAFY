package com.ssafy.yun;

import java.util.Scanner;

public class Baek_10871 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int X = sc.nextInt();
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			if(a<X) {
				System.out.printf("%d ",a);
			}
		}

	}

}
