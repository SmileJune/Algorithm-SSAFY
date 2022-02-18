package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2527_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 4; t++) {
			int x_a1 = sc.nextInt(); 
			int y_a1 = sc.nextInt();
			int x_a2 = sc.nextInt();
			int y_a2 = sc.nextInt();
			int x_b1 = sc.nextInt();
			int y_b1 = sc.nextInt();
			int x_b2 = sc.nextInt();
			int y_b2 = sc.nextInt();
			
			if (x_b1 > x_a2 || x_b2 < x_a1 || y_b1 > y_a2 || y_b2 < y_a1)
				System.out.println("d");
			
			else if ((x_b1 == x_a2 && y_b1 == y_a2) || (x_b1 == x_a2 && y_b2 == y_a1)
                     || (x_b2 == x_a1 && y_b1 == y_a2) || (x_b2 == x_a1 && y_b2 == y_a1))
					System.out.println("c");
				
			else if ((x_b1 == x_a2) && (!(y_b1 >= y_a2) || !(y_a1 >= y_b2))
                     || (y_b2 == y_a1) && (!(x_b1 >= x_a2) || !(x_a1 >= x_b2))
                     || (x_b2 == x_a1) && (!(y_b1 >= y_a2) || !(y_a1 >= y_b2)) 
                     || (y_b1 == y_a2) && (!(x_b1 >= x_a2) || !(x_a1 >= x_b2)))
		            System.out.println("b");
			
			else System.out.println("a");
		}
		
		sc.close();
	}
}