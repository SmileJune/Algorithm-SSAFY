package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1225 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d%s\n",tc,solution());
		}
	}
	
	static StringBuilder solution() throws IOException {
		br.readLine();
		st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 8; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		outer : while(true) {
			int cnt = 1;
			int item;
			while(cnt <= 5){
				item = queue.remove() - cnt;
				if(item <= 0) {
					queue.add(0);
					break outer;
				}
				queue.add(item);
				cnt++;
			}
			
		}
		
		while(!queue.isEmpty()) {
			sb.append(" ").append(queue.poll());
		}
		
		return sb;
		
	}
}
