package com.ssafy.namja;

import java.util.Scanner;
public class SWEA_4789_박성현 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			sc.nextLine();
			for (int t = 1; t <= T; t++) {
				char[] nums = sc.nextLine().toCharArray();
				int total = 0;
				int cnt = 0;
				for (int i = 0; i < nums.length; i++) {
					if (i > total && nums[i] != '0') {
						cnt += i - total;
						total += cnt;
					}
					total += nums[i] - '0';
				}
				System.out.printf("#%d %d\n",t,cnt);
			}
		}
	}