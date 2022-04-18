package com.ssafy.hwang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 위상정렬
 * 1. 간선 정보 저장 & 진입차수 카운트
 * 2. 진입차수가 0인 애들 찾고 큐를 사용하여 풀이
 */
public class Day69_BOJ_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer>[] adjList = new ArrayList[N+1];
		for(int i = 1 ; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		// 진입차수
		int[] indegree = new int[N+1];
		
		// 주어진 유향 간선 정보 입력
		for(int i =0; i< M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			adjList[st].add(ed);
			indegree[ed]++; // 진입 차수를 알아야하기때문에 카운트
		}
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입차수가 0인 것들만 큐에 넣고
		for(int i =1 ; i<N+1;i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur+" ");
			// cur에서 진출하는 노드번호의 진입차수를 줄여준다
			for(int next : adjList[cur]) {
				indegree[next]--;
				// 새로 나온 진입차수 0을 찾아 queue에 넣어준다.
				if(indegree[next]==0)
					queue.add(next);
			}
		}
		// 만약 모든 노드를 돌기 전 queue가 공백상태가 된다면 사이클 존재한다는 의미
		System.out.println(sb.toString());
	}
}
