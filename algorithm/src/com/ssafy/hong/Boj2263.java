package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj2263 {
	
	/**
	 * [BOJ: 2263] 트리의 순회
	 * n개의 정점을 갖는 이진 트리에서 인오더와 포스트오더 정보가 주어 졌을 때,
	 * 프리오더를 구하시오
	 * 
	 * input:	N		 N개의 정점
	 * 			i1 i2..  인 오더
	 * 			p1 p2..  포스트 오더
	 * 
	 * output:	a1 2.. 프리 오더
	 */
	
	static int[] in;
	static int[] post;
	static int[] pre;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		in = new int[N];
		post = new int[N];
		pre = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)in[i]=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)post[i]=Integer.parseInt(st.nextToken());
		
		findPre(0, N, 0, N-1, post[N-1]);
		for(int i=0; i<N; i++)sb.append(pre[i]).append(' ');
		bw.append(sb).flush();
	}
	static void findPre(int s, int e, int ss, int ee, int val) {
		if(ss == ee) {
			pre[n++]=val;
			return;
		}
		int index = s;
		while(index < e && in[index] != val) {
			index++;
		}
		int temp = e - index - 1;
		pre[n++] = val;
		if(ee-temp-1 >= ss)findPre(s,index, ss, ee-temp-1, post[ee-temp-1]);
		if(ee-1 >= ee-temp)findPre(index+1, e, ee-temp, ee-1,post[ee-1]);
	}
}
