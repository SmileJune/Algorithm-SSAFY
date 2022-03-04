package com.ssafy.woong;

import java.util.Scanner;

public class B2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int base = sc.nextInt();
		int comp = sc.nextInt();
		
		if(base < comp) {
			base = comp;
			for(int i = 0 ; i < 6; i++) {
				comp = sc.nextInt();
				if(base > comp) {
					System.out.println("mixed");
					return;
				}
				base = comp;
			}
			System.out.println("ascending");
			return;
	
		}
		else {
			base = comp;
			for(int i = 0 ; i < 6; i++) {
				comp = sc.nextInt();
				if(base < comp) {
					System.out.println("mixed");
					return;
				}
				base = comp;
			}
			System.out.println("descending");
			return;
			
		}
		
	}

}
