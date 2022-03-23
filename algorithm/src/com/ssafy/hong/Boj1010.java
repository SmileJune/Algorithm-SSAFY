package com.ssafy.hong
import java.util.*;

public class Boj1010 {
	static long[][] combi = new long[31][31];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		combi[0][0] = 1;
		for(int i = 1; i < 31; i++) {
			for(int j = 0; j <= i; j++) {
				combi[i][j] += combi[i-1][j];
				if(j-1 >= 0)combi[i][j] += combi[i-1][j-1];
			}
		}
		
		while(T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(combi[M][N]);
		}
	}
}
