package com.ssafy.day1.hwang;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1085 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = Integer.MAX_VALUE;
		
		int distanceX = Math.abs(x-w);
		int distanceY = Math.abs(y-h);
		
		int[] arr = {x,y,distanceX,distanceY};
		for(int i = 0; i<arr.length;i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		System.out.println(min);
	}
}
