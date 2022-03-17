package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.*;

public class Boj11437 {
	static List<Integer>[] adj;
	static int[] dep;
	static int[][] par;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N];
		dep = new int[N];
		par = new int[N][21];
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<>();
			for(int j=0; j<20; j++) par[i][j] = -1;
		}
		StringTokenizer st;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			adj[s].add(e);
			adj[e].add(s);
		}
		
		dfs(0,-1);
		
		for(int j=0; j<20; j++) {
			for(int i=0; i<N; i++) {
				if(par[i][j] != -1) {
					par[i][j+1] = par[par[i][j]][j];
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			sb.append(lca(s,e)+1).append('\n');
		}
		bw.append(sb).flush();
	}
	
	static int lca(int s, int e) {
		if(dep[s] < dep[e]) {
			int temp = s; s= e; e= temp;
		}
		int d = dep[s] - dep[e];
		
		for(int j = 0; d>0; j++) {
			if((d&1) == 1) {
				s=par[s][j];
			}
			d>>=1;
		}
		
		if(s == e)return s;
		for(int j=20; j>=0; j--) {
			if(par[s][j] != par[e][j] && par[s][j]!=-1) {
				s=par[s][j];
				e=par[e][j];
			}
		}
		return par[s][0];
	}
	static void dfs(int curr, int pa) {
		for(Integer next : adj[curr]) {
			if(pa == next)continue;
			par[next][0] = curr;
			dep[next] = dep[curr] + 1;
			dfs(next, curr);
		}
	}
	
}
