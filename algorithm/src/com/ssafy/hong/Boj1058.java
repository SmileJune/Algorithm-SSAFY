package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Boj1058 {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] rel = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				rel[i][j]=str.charAt(j);
			}
		}
		int[] ans = new int[N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) if(i!=j){
				if(rel[i][j] == 'Y') {
					ans[i]++;
				}
				else {
					for(int k=0; k<N; k++) {
						if(k != i && k != j && rel[i][k] == rel[j][k] && rel[j][k] == 'Y') {
							ans[i]++;
							break;
						}
					}
				}
			}
		}
		int res = 0;
		for(int i=0; i<N; i++)if(res < ans[i])res=ans[i];
		System.out.println(res);
	}
}
