package com.ssafy.hwang;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day61_BOJ_안전영역 {
	static int map[][],N, tmpArea;
	static boolean marked[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		int minH = 100;
		int maxH = 0;
		for(int i =0 ; i<N;i++) {
			for(int j = 0; j<N;j++) {
				map[i][j] = sc.nextInt();
				if(minH>map[i][j]) minH = map[i][j];
				if(maxH<map[i][j]) maxH = map[i][j];
			}
		}
		int res=0;
		for(int h =minH; h<maxH;h++) {
			marked = new boolean[N][N];
			tmpArea = 0;
			for(int i=0;i<N;i++) {
				for(int j =0 ; j<N;j++) {
					if(map[i][j]<=h) continue;
					if(marked[i][j]) continue;
					tmpArea++;
					bfs(i,j,h);
					
				}
			}
			res = Math.max(tmpArea, res);
		}
		if( res==0) res=1;
		System.out.println(res);
	}
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static Queue<Node> queue;
	private static void bfs(int r, int c,int h) {
		queue = new LinkedList<>();
		queue.add(new Node(r,c));
		marked[r][c] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i =0;i<4;i++) {
				int nr = node.r+dr[i];
				int nc = node.c + dc[i];
				if(isNotRange(nr,nc)) continue;
				if(marked[nr][nc]) continue;
				if(map[nr][nc]>h) {
					marked[nr][nc]=true;
					queue.add(new Node(nr,nc));
				}
			}
			
		}
	}
	private static boolean isNotRange(int r, int c) {
		if(r<0||c<0||r>=N||c>=N) return true;
		return false;
	}
}