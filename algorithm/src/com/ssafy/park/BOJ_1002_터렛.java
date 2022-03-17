package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002_터렛 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			if (x1 == x2 && y1 == y2 ) {
				if (r1 == r2) {					
					sb.append(-1 + "\n");
					continue;
				} else {
					sb.append(0 + "\n"); 
					continue;
				}
			}
			else if (Math.sqrt((Math.pow((x1-x2),2) + Math.pow((y1-y2), 2))) == r1 + r2 ) {
				sb.append(1 + "\n");
				continue;
			} else if (Math.sqrt((Math.pow((x1-x2),2) + Math.pow((y1-y2), 2))) > r1 + r2) {
				sb.append(0 + "\n");
			}
			else {
				sb.append(2 + "\n");	
			}
		}
		System.out.println(sb);
	}
}
