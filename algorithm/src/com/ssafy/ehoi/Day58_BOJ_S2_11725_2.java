package com.ssafy.ehoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day58_BOJ_S2_11725_2 {
	// 노드 클래스 만들기
	static class Node {
		// 내 노드 정점 번호
		int val;
		// 내 자식들 관리할 리스트
		List<Integer> children = new ArrayList<>();
	}
	
	static Node[] nodes;
	static int[] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 노드의 개수를 입력 받고
		int n = sc.nextInt();
		// 역시나 1번부터 사용할 것이기 때문에 배열 크기를 1 크게 생성한다
		nodes = new Node[n+1];
		// 정답 배열도 똑같이 만들고 2부터 출력하자
		ans = new int[n+1];
		
		for(int i = 0; i < nodes.length; i++ ) {
			nodes[i] = new Node();
		}
		
		for(int i = 0; i < n-1 ; i++) {
			// 두 정점을 입력받고
			int s = sc.nextInt();
			int e = sc.nextInt();
			// 서로의 노드에 서로를 자식으로 추가한다. 
			nodes[s].children.add(e);
			nodes[e].children.add(s);
		}
		
		// 그리고 이제 루트인 1부터 시작해서 누가 자식이고 누가 부모인지 서열을 정리해보자.. ㅎ
		recur(1, -1); // 현재 노드는 루트인 1이고, 부모는 -1, 즉 없다는 뜻이다.
		
		for (int i = 2; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
		sc.close();
	}
	
	public static void recur(int curr, int par) {
		ans[curr] = par;
		// 베이스 파트 : 재귀를 던졌는데 만약 자식이 하나라면 = 리프노드 이므로 그냥 리턴
		if(nodes[curr].children.size() == 1 && par != -1) return;
		
		// 재귀 파트
		// 조건 : curr의 자식이 par가 아니라면, 
		for (int child : nodes[curr].children) {
			if (child != par)
				recur(child , curr);
		}
		
	}
}
