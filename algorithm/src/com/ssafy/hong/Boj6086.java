package com.ssafy.hong;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj6086 {
	/**
	 * [BOJ: 6086] 최대 유량
	 * 'A' 에서 'Z'로 흐르는 최대 유량을 계산 하라.
	 * 노드는 대소문자를 구분하여 알파벳으로 존재한다.
	 * 
	 * input:	N		N개의 노드
	 * 			s e c	시작, 도착, 용량
	 * 			...			
	 * output:	ans		최대 유량
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int INF = 1<<30;
		final int MAX = 62;
		int[][] c = new int[MAX][MAX];
		int[][] f = new int[MAX][MAX];
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int s = sc.next().charAt(0)-'A';
			int e = sc.next().charAt(0)-'A';
			int v = sc.nextInt();
			
			c[s][e]+=v;
			c[e][s]+=v;
		}
		
		int flow = 0;
		while(true) {
			int[] par = new int[MAX];
			for(int i=0; i<MAX; i++)par[i]=-1;
			
			par[0]=0;
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			
			while(!q.isEmpty() && par['Z'-'A']==-1) {
				int curr = q.poll();
				
				for(int next = 0 ; next < MAX; next++) {
					if(c[curr][next]-f[curr][next] > 0 && par[next]==-1) {
						q.add(next);
						par[next]=curr;
					}
				}
			}
			
			if(par['Z'-'A']==-1)break;
			int amount = INF;
			for(int next = 'Z'-'A'; next != 0 ; next=par[next]) {
				if(amount > c[par[next]][next] - f[par[next]][next]) {
					amount = c[par[next]][next] - f[par[next]][next];
				}
			}

			for(int next = 'Z'-'A'; next != 0 ; next=par[next]) {
				f[par[next]][next] += amount;
				f[next][par[next]] -= amount;
			}
			flow += amount;
		}
		System.out.println(flow);
	}
}
