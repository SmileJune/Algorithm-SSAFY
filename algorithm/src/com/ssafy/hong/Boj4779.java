package com.ssafy.hong;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj4779 {
	/**
	 * [BOJ: 4779] 칸토어 집합
	 * 구간 [0,3^N]을 삼등분 하여 가운데 구간을 반복적으로 ' '로 바꿈
	 * ' '가 아닌 곳은 '-'로 출력
	 * 
	 * input:	N	지수
	 * 			..	파일 끝날때 까지
	 * 
	 * output:	ans	결과 출력물
	 */
	static char[] ans = new char[531442];
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] three = new int[13];
		three[0]=1;
		for(int i=1; i<13; i++) {
			three[i]=three[i-1]*3;
		}
		
		while(sc.hasNextInt()) {
			int N = three[sc.nextInt()];
			recur(0,N,'-');
			for(int i=0; i<N; i++)bw.append(ans[i]);
			bw.append('\n');
			bw.flush();
		}
	}
	
	static void recur(int s, int e, char ch) {
		if(s+1==e) {
			ans[s]=ch;
			return;
		}
		if(ch==' ') {
			for(int i=s; i<e; i++) ans[i]=ch;
			return;
		}
		int r1 = (e-s)/3;
		recur(s,s+r1,ch);
		recur(s+r1,e-r1, ' ');
		recur(e-r1, e, ch);
	}
}
