package com.ssafy.ehoi;

import java.util.Scanner;


public class Codeup1255 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double a = Double.parseDouble(sc.next());
		double b = Double.parseDouble(sc.next());
		
		
		while (a <= b) {
			System.out.printf("%.2f ", a);
			a += 0.01;
		}
		
		
		sc.close();
	}
}
