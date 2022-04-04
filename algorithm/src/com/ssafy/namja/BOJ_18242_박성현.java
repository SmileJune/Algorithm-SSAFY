package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_18242_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();

		boolean isUp = false;
		int start = -1;
		int end = -1;
		char[][] square = new char[N][M];
		for (int i = 0; i < N; i++)
			square[i] = sc.nextLine().toCharArray();
		
		for (int i = 0; i < N; i++) {
			String line = String.copyValueOf(square[i]);
			if (line.contains("#")) {
				int temp_start = start;
				int temp_end = end;
				start = line.indexOf("#");
				end = line.lastIndexOf("#");
				
				if (start == temp_end) {
					System.out.println("LEFT");
					break;
				}
				else if (end == temp_start) {
					System.out.println("RIGHT");
					break;
				}
			}
			
			
			if ((isUp && !line.contains("#")) || (i == N - 1 && !isUp)) {
				System.out.println("DOWN");
				break;
			}
			else if (isUp && line.contains("#")) {
				System.out.println("UP");
				break;
			}
			if (line.contains("#.#")) 
				isUp = true;
		}
	}
}
