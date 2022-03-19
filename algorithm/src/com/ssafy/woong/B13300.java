package com.ssafy.woong;

import java.util.LinkedList;
import java.util.Scanner;

public class B13300 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] rooms = new int[7][2];
		int cnt = 0;
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			
			if(rooms[grade][gender] == 0) {
				cnt++;
			}
			rooms[grade][gender] += 1;
			if(rooms[grade][gender] > k) {
				rooms[grade][gender] -= k;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
