package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day70_BOJ_S1_15900 {
	static class Node{
		int v;
		List<Integer> children = new ArrayList<>();
	}
	static int N, ans;
	static Node[] nodes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N+1];
		ans = 0;
		
		// 노드 배열 세팅
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node();
			nodes[i].v = i;
		}
		
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// 일단 누가 누구의 자식인지 모르니까 서로를 자식으로 담아두기! 무방향 그래프처럼
			nodes[s].children.add(e);
			nodes[e].children.add(s);
		}
		
		// 입력은 다했다 이제 루트노드부터 내려가면서 각 리프노드까지의 이동수를 구해보자
		recur(1, -1, 0); // 현재 노드는 1, 부모노드는 -1, 이동횟수는 0이라는 뜻이다.
		
//		System.out.println(ans);
		if (ans % 2 == 0) {
			System.out.println("No");
		} else System.out.println("Yes");
	}
	private static void recur(int curr, int par, int cnt) {
		// base
		if (nodes[curr].children.size()==1 && nodes[curr].children.get(0) == par) { // 리프노드니까
			// 지금까지 내려온 거 cnt 더하자
			ans += cnt;
			return;
		}
		
		
		// recur
		for(int child : nodes[curr].children) {
			if(child == par) continue;
			recur(child, curr, cnt +1);
		}
		
	}
}
