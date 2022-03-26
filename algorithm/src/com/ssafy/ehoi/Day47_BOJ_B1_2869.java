package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day47_BOJ_B1_2869 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double up = Integer.parseInt(st.nextToken());
		double down = Integer.parseInt(st.nextToken());
		double height = Integer.parseInt(st.nextToken());
		
		int day_up = (int)(Math.ceil((height-up)/(up-down)))+1;
		
		int day_night = (int)Math.ceil(height/(up-down));
		
		int day = Math.min(day_up, day_night);

//		System.out.println(day_up);
//		System.out.println(day_night);
		System.out.println(day);
		
//		sc.close();
	}
}
