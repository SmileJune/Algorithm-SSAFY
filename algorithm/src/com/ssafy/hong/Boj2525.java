package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2525 {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		m += sc.nextInt();
		
		h+=m/60;
		m%=60;
		h%=24;
		System.out.println(h+" "+m);
	}
}
