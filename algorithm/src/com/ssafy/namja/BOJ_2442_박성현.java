package com.ssafy.namja;
import java.util.Scanner;

public class BOJ_2442_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int blank = N - i;
			int star = 2 * i - 1;
			
			for (int j = 0; j < blank; j++)
				System.out.print(" ");
			for (int j = 0; j < star; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}