package com.ssafy.hwang;

import java.util.Scanner;

public class Day44_BOJ_배수와약수 {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
        
		while(true) {
			
			int first = in.nextInt();
			int second = in.nextInt();
			
			if(first == 0 && second == 0) break;
			
			if(second % first == 0) {
				System.out.println("factor");
			}
			else if(first % second == 0) {
				System.out.println("multiple");
			}
			else {
				System.out.println("neither");
			}
		}
 
	}
 
}