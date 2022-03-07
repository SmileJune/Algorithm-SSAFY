package com.ssafy.namja;
import java.util.Scanner;

public class SWEA_4698_박성현 {
		static boolean[] prime = new boolean[1000000];
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			prime[0] = true;
			for (int i = 2; i <= 1000000; i++) {
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						prime[i-1] = true;
						break;
					}
				}
			}
			for (int t = 1; t <= T; t++) {
				int D = sc.nextInt();
				int A = sc.nextInt();
				int B = sc.nextInt();
				int total = 0;
				for (int i = A; i <= B; i++) {
					if (prime[i-1] == false && (i+"").contains(D+""))
						total++;
				}
				System.out.printf("#%d %d\n",t,total);
			}
		}
	}