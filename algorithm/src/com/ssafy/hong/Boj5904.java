package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5904 {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean flag= false;
		char ans = '\0';
		while(!flag) {
			int temp = 0, prev = 0, n = 0;
			while(temp <= N) {
				prev = temp;
				temp = 2*prev + 2 + (++n);
			}
			if(prev + 1 == N) {
				ans = 'm';
				flag = true;
			}
			else if(prev + 2 + n >= N) {
				ans = 'o';
				flag = true;
			}
			else {
				N -= prev+2+n;
			}
		}
		System.out.println(ans);
	}
}
