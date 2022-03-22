package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1547_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int start = 1;
		boolean[] balls = {false,true,false,false};
		for (int i = 0; i < N; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			boolean temp = balls[X];
			balls[X] = balls[Y];
			balls[Y] = temp;
		}
		for (int i = 0; i < 4; i++) 
			if (balls[i])
				System.out.println(i);
	}
}