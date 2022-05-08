package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
	static int result = 0;
	static ArrayList<Integer>[] friends;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		friends = new ArrayList[n];		
		for(int i = 0; i < n; i++) {
			friends[i] = new ArrayList<>();
		}		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());			
			friends[v1].add(v2);
			friends[v2].add(v1);
		}
		
		for(int i = 0; i < n; i++) {
			if(result == 1) {
				break;
			}
			HashSet<Integer> hs = new HashSet<>();
			dfs(i, hs);
		}		
		System.out.println(result);
	}	
	static void dfs(int now, HashSet<Integer> hs) {
		if(5 <= hs.size()) {
			result = 1;
			return;
		}
		if(result == 1) {
			return;
		}	
		for(Integer next : friends[now]) {
			if(hs.contains(next)) {
				continue;
			}
			hs.add(next);
			dfs(next, hs);
			hs.remove(next);
		}
	}
}