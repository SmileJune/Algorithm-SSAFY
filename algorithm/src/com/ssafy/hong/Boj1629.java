package com.ssafy.hong;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj1629 {
	
	/**
	 * [BOJ: 1629] 곱셈
	 * A를 B번 곱한 수를 C로 나눠서 출력.
	 * 
	 * input:	A B C
	 * output:	ans
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		System.out.println(multiple(A,B,C));
	}
	
	static int multiple(int a, int b, int c) {
		if(b == 1)return a%c;
		long temp = (1L*multiple(a,b/2,c)%c);
		
		return b%2 == 0? (int)((temp%c*temp%c)%c) : (int)((temp%c*temp%c*a%c)%c);
	}
	
}
