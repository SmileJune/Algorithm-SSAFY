package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2527 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		for(int tc = 1; tc <= 4; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			//check D
			if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
				System.out.println("d");
			}
			//check C
			else if(
					(y2 == q1 && p2 == x1) || 
					(x1 == p2 && y1 == q2) ||
					(x2 == p1 && y2 == q1) ||
					(x2 == p1 && q2 == y1)) {
				System.out.println("c");
			}
			else if(x1 == p2 || x2 == p1 || y1 == q2 || y2 == q1){
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
	}

}

/*
 * x1 < x2 , y1 < y2, p1 > p2, q1 > q2 = > s1 안에  s2
 * x1 < x2.  y1 < x2, p1 < p2, q1 < q2 = > 걸침
 * 
 *
 * 
 * 
 */
