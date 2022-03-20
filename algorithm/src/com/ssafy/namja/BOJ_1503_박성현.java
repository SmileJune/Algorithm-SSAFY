package com.ssafy.namja;
import java.util.Scanner;

public class BOJ_1503_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] set = new int[1002]; 
			
		for (int i = 0; i < S; i++) 
			set[sc.nextInt()] = 1;
		int min = Integer.MAX_VALUE;
		int limit = Integer.MAX_VALUE;
		int cnt = 0;
		
		for (int x = 1; x <= 1000; x++) {
			if (set[x] == 1)
				continue;
			for (int y = x; y <= 1000; y++) {
				if (set[y] == 1)
					continue;
				for (int z = y; z <= 1001; z++) {
					if (set[z] == 1)
						continue;
					min = Math.min(min, Math.abs(N-x*y*z));
				}
			}
		}
		System.out.println(min);
	}
}