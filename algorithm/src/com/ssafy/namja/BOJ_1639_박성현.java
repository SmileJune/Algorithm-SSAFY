package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1639_박성현 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			String ticket = sc.nextLine();
			
			int max = 0;
			for (int i = 2; i <= ticket.length(); i+=2) {
				for (int j = 0; j < ticket.length() - i + 1; j++) {
					String num = ticket.substring(j,j+i);
					String num1 = num.substring(0,i/2);
					String num2 = num.substring(i/2);
					
					int total1 = 0, total2 = 0;
					for (char s: num1.toCharArray()) {
						total1 += s - '0';
					}
					for (char s : num2.toCharArray()) {
						total2 += s - '0';
					}
					if (total1 == total2) {
						max = i;
						break;
					}
				}
			}
			
			System.out.println(max);
		}
	}