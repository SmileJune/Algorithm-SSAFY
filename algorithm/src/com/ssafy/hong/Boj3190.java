package com.ssfy.hong;
import java.util.*;

public class Boj3190 {
	/**
	 * [BOJ: 3190] 뱀
	 * 'Dummy' 라는 도스게임이 있다. 
	 * 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 
	 * 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
	 * 게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 
	 * 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다.
	 * 뱀은 처음에 오른쪽을 향한다.
	 * 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.
	 * 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
	 * 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
	 * 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
	 * 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.
	 * 
	 * input : N		맵 크기
	 * 		   K		사과 수
	 * 		   y1 x1	사과 위치
	 * 		   ..
	 * 		   W		커맨드 수
	 * 		   t1 c		시간 방향 전환
	 * output: ans		살아남는 시간	
	 */
	static int[][] map;
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static P head, tail;
	static int N;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		map[0][0] = 1;
		
		head = new P(0,0);
		tail = head;
		
		
		int A = sc.nextInt();
		for(int i=0; i<A; i++) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			map[y][x] = 2;
		}
		
		A = sc.nextInt();
		int now = 0;
		boolean flag = true;
		for(int i=0; i<A; i++) if(flag) {
			int t = sc.nextInt(); 
			char c = sc.next().charAt(0);
			
			while(now < t && (flag=move())) {
				now++;
			}
			head.changeDir(c);
		}
		while(flag && move()) {
			now++;
		}
		System.out.println(now+1);
	}
	static boolean move() {
		head.next = head.move();
		P tmp =head.next;
		
		if(tmp.y <0 || tmp.y >=N || tmp.x<0 || tmp.x>=N || map[tmp.y][tmp.x]==1) {
			return false;
		}
		int temp = map[tmp.y][tmp.x];
		
		head = tmp;
		map[head.y][head.x]=1;
		if(temp==0) {
			map[tail.y][tail.x]=0;
			tail=tail.next;
		}
		return true;
	}
	static class P{
		int y, x, dir;
		P next;
		P(int y, int x){this(y,x,0);}
		P(int y, int x, int dir){this.y=y; this.x=x; this.next = null; this.dir = dir;}
		void changeDir(char c){
			this.dir = c == 'D'? (dir + 3) % 4 : (dir + 1)%4;
		}
		
		P move() {
			return new P(y+dy[dir], x+dx[dir], dir);
		}
	}
}
