package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1598_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int Y = sc.nextInt();
		int temp = Math.min(X, Y);
		Y = Math.max(X, Y);
		X = temp;
		
		int x_row, x_col = 0, y_row, y_col = 0;
		
		x_row = (X - 1) % 4 + 1;
		y_row = (Y - 1) % 4 + 1;
		
		int i = 0;
		while(true) {
			if ((4 * i + 1) <= X && X <= 4 * (i + 1))
				break;
			i++;
			x_col++;
		}
		i = 0;
		while(true) {
			if ((4 * i + 1) <= Y && Y <= 4 * (i + 1))
				break;
			i++;
			y_col++;
		}
		
		System.out.println((Math.abs(y_row - x_row) + Math.abs(y_col - x_col)));		
	}
}
