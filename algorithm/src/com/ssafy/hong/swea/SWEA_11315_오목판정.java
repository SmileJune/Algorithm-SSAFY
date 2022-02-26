package com.ssafy.hong;
import java.io.IOException;
import java.util.*;

public class SWEA_11315_오목판정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t=0;
		char[][] map = new char[21][];
		
		int[] dr = {0,1,1,1};
		int[] dc = {1,1,0,-1};
		
		while(t++<T) {
			int N = sc.nextInt();
			for(int i=0; i<N; i++) {
				String str = sc.next();
				map[i]=str.toCharArray();
			}
			boolean flag= false;
			
			outer :
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)if(map[i][j]=='o') {
					for(int k=0; k<4; k++) {
						int tr = i, tc = j;
						int cnt = 1;
						while(tr + dr[k] >= 0 && tc + dc[k] >= 0 && tr + dr[k] < N && tc + dc[k] < N && map[tr + dr[k]][tc + dc[k]] == 'o') {
							cnt++;
							tr += dr[k];
							tc += dc[k];
						}
						if(cnt>=5) {
							flag=true;
							break outer;
						}
					}
				}
			}
			
			System.out.printf("#%d %s\n",t,flag?"YES":"NO");
		}
	}
}
