package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {
	static int count[] = new int[101];
	static int snake[] = new int[101];
	static boolean visited[] = new boolean[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 

		for(int i = 0; i < n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			snake[a] = b;
		}
		
		bfs();
	}
	
	static void bfs() {
		Queue<Integer> pq = new LinkedList<Integer>();
		pq.offer(1);
		count[1] = 0;
		visited[1] = true;
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			if(cur == 100) {
				System.out.println(count[cur]);
				return;
			}

			for(int i = 1; i < 7; i++) {
				int x = cur + i;
				if(100 < x) continue;
				if(visited[x]) continue;
				visited[x] = true;
				
				if(snake[x] != 0) { 
					if(!visited[snake[x]]) {
						pq.offer(snake[x]);	
						visited[snake[x]] = true;
						count[snake[x]] = count[cur] + 1;
					}
				}else { 
					pq.offer(x);
					count[x] = count[cur] + 1;
				}
			}
		}
	}

}