package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	public static class point {
		int r;
		int c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static point target;
	static int[] dr = { 0, 0, 1, 0 };
	static int[] dc = { 0, 1, -1, 1 };
	static boolean find = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		target = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		point left = new point(0, 0);
		point right = new point((int) Math.pow(2, N) - 1, (int) Math.pow(2, N) - 1);
		divide(left, right, 0);
	}

	public static void divide(point left, point right, int cnt) {
		if (find) return;
		if (right.r - left.r  == 1) {
			int r = left.r;
			int c = left.c;
			for (int i = 0; i < 4; i++) {
				r += dr[i];
				c += dc[i];
				if (r == target.r && c == target.c) {
					System.out.println(cnt+i);
					find = true;
					break;
				}
			}
			return;
		} else {			
			int midr = (left.r + right.r) / 2;
			int midc = (left.c + right.c) / 2;
			if (target.r <= midr) {
				if (target.c <= midc) {					
					divide(left, new point(midr, midc), cnt);
				} else {
					cnt += (midr - left.r + 1) * (midc - left.c + 1);
					divide(new point(left.r, midc + 1), new point(midr, right.c), cnt);
				}
			}
			else {
				if (target.c <= midc) {	
					cnt += (midr - left.r + 1) * (right.c - left.c + 1);
					divide(new point(midr + 1, left.c), new point(right.r, midc), cnt);
				} else {
					cnt += (midr - left.r + 1) * (right.c - left.c + 1) 
							+ (midr - left.r + 1) * (midc - left.c + 1);
					divide(new point(midr + 1, midc + 1), right, cnt);
				}
			}
		}
	}
}
