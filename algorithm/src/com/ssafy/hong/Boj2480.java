package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2480 {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int[] dice = new int[7];
		for(int i=0; i<3; i++) {
			dice[sc.nextInt()]++;
		}
		int cnt = 0, num = 0;
		for(int i=1; i<7; i++) {
			if(cnt <= dice[i]) {
				cnt = dice[i];
				num = i;
			}
		}
		System.out.println(cnt==3?10000+num*1000:cnt==2?1000+num*100:num*100);
	}
}
