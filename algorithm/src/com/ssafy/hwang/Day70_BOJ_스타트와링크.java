package com.ssafy.hwang;

import java.util.*;

public class Day70_BOJ_스타트와링크 {
	static int res,sel[],map[][],N;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		res = Integer.MAX_VALUE;
		map = new int[N][N];
		sel = new int[N];
		for(int i =0; i<N;i++) {
			for(int j=0; j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력 끝
		
		comb(0,0);
		System.out.println(res);
	}
	
	static void comb(int idx,int sidx) {
		if(sidx==sel.length/2) {
			check();
			return;
		}
		
		for(int i = idx; i<N;i++) {
			if(sel[i]==1) continue;
			sel[i] = 1;
			comb(i+1,sidx+1);
			sel[i] = 0;
		}
	}

	private static void check() {
		int sumS = 0;
		int sumL = 0;
		for(int i =0 ; i<sel.length-1;i++) {
			for(int j =i+1 ; j<sel.length;j++) {
				if(sel[i]!=0 && sel[j]!=0) {
					sumS += map[i][j] + map[j][i];
				}
				else if(sel[i]==0 && sel[j]==0) {
					sumL += map[i][j] + map[j][i];
				}
			}
		}
		res = Math.min(res, Math.abs(sumS-sumL) );
	}
}
