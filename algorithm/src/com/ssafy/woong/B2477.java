package com.ssafy.woong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class B2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] visited = new int[6][2];
		Queue<int[]> queue = new LinkedList<>();
		int rMax = 0;
		int cMax = 0;
		
		for(int i = 0; i < 6; i++) {
			int d = sc.nextInt();
			int len = sc.nextInt();			
			cMax = (d == 4 || d == 3) && len > cMax ? len : cMax; 
			rMax = (d == 2 || d == 1) && len > rMax ? len : rMax;
			queue.add(new int[] {d, len});
		}
		int bigSquare = cMax * rMax;
		
		while(true) {
			if(queue.peek()[1] != rMax) {
				queue.add(queue.poll());
				continue;
			}
			break;
		}
		
		outer : for(int i = 0 ; i < 6; i++) {
			visited[i] = queue.poll();
			for(int j = 0; j < i; j++) {
				if(visited[j][0] == visited[i][0]) {
					int square = visited[i][1] * visited[j+1][1];
					System.out.println((bigSquare - square) * n);
					break outer;
				}
			}
		}
		
		
	}
}
