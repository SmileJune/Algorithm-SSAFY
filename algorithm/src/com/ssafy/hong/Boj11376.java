package com.ssafy.hong;
import java.itil.*;

public class Boj11376{
	/**
	 * [BOJ: 11376] 열혈강호2
	 * 직원 N명과 해야할 일 M개가 있다.
	 * 각 일을 담당하는 사람은 1명이여야 하고
	 * 직원은 최대 두 개의 일을 할 수 있다.
	 * 
	 * input:	N M		 직원 수, 해야할 일
	 * 			n a1 a2	 i번째 직원이 할 수있는 일의 개수, 일 번호
	 * 			...
	 * output:	ans		 회사에서 최대로 할 수 있는 일
	 */
	static boolean[] visit;
	static List<Integer>[] adj;
	static int[] match;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i=0; i<N; i++)match[i]=-1;
		
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<>();
			int n = sc.nextInt();
			while(n-->0) {
				int w = sc.nextInt();
				adj[i].add(w-1);
			}
		}
		int ans = 0;
		for(int i=0; i<2*N; i++) {
			visit = new boolean[N];
			if(dfs(i/2))ans++;
		}
		System.out.println(ans);
	}
	static boolean dfs(int curr) {
		if(visit[curr])return false;
		visit[curr]= true;
		for(int next : adj[curr]) {
			if(match[next] == -1 || dfs(match[next])) {
				match[next]=curr;
				return true;
			}
		}
		return false;
	}
}
