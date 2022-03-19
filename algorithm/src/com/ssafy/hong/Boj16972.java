package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj16972{
	/**
	 * [BOJ: 16927] 배열 돌리기2
	 * N*M배열 반시계방향으로 R만큼 돌린다
	 * 돌리는 규칙은 문제 참고
	 * 
	 * input:	N M R	행, 열, 돌리는 횟수
	 * 			a1 a2..	배열
	 * 			..
	 * output:	b1 b2.. 결과 배열
	 * 			..
	 */
	static int[][] temp;
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		temp = new int[N][M];
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());;
			}
		}
		
		for(int i=0; i<(N+1)/2 && 2*i<M; i++) {
			int r = R%((N-i-i)*2+(M-i-i)*2-4);
			rotate(i, r, map);
		}
		for(int i=0; i<N; i++) {
			for(int j=0 ;j<M; j++)sb.append(map[i][j]).append(' ');
			sb.append('\n');
		}
		bw.append(sb);
		bw.flush();
	}
	
	static void rotate(int n, int r, int[][] map) {
		int sr = n, er = N-1-n, sc = n, ec = M-1-n;
		
		Template template = new Template();
		
		template.execute(sr, er, sc, ec, (i,j)->temp[i][j] = map[i][j]);
		
		template.execute(sr, er, sc, ec, (i,j)->{
			int tr = r;
			int ty =i, tx =j;
			while(tr>0) {
				if(ty==sr && tx>sc) {
					if(tr >= tx - sc) {
						tr-=(tx-sc);
						tx=sc;
					}
					else {
						tx-=tr;
						tr=0;
					}
				}
				else if(ty==er && tx<ec) {
					if(tr >= ec - tx) {
						tr-=(ec-tx);
						tx=ec;
					}
					else {
						tx+=tr;
						tr=0;
					}
				}
				else if(tx==sc && ty<er) {
					if(tr >= er - ty) {
						tr-=(er-ty);
						ty=er;
					}
					else {
						ty+=tr;
						tr=0;
					}
				}
				else if(tx==ec && ty>sr) {
					if(tr >= ty - sr) {
						tr-=(ty-sr);
						ty=sr;
					}
					else {
						ty-=tr;
						tr=0;
					}
				}
			}
			temp[ty][tx] = map[i][j];	
		});
		
		template.execute(sr, er, sc, ec, (i,j)->map[i][j] = temp[i][j]);
	}
	
	static interface Callback{
		public void run(int f, int s);
	}
	static class Template{
		
		public void execute(int sr, int er, int sc, int ec, Callback callback) {
			for(int i=sr; i<=er; i++) {
				if(i==sr || i==er) {
					for(int j=sc; j<=ec; j++) {
						callback.run(i, j);
					}
				}
				else{
					callback.run(i, sc);
					callback.run(i, ec);
				}
			}
		}
	}
}
