package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇{
	static int N, K, left, right, answer;
	static int[] map;
	static boolean[] robot;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 컨베이어 벨트 길이 2*N 
		map = new int[2*N];
		// 로봇 위치 N
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < 2*N ; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		left = 0;
		right = N;
		
		while(K>0) {
			answer++;
			moveBelt();
			moveRobot();
			newRobot();
		}
		System.out.println(answer);
	}
	
	private static void moveBelt() {
		left --;
		if(left < 0) {
			left = 2*N -1;
		}
		right --;
		if(right < 0) {
			right = 2*N - 1;
		}
		// 벨트가 움직임에 따라 로봇 위치 재조정 robot은 길이가 N, 0이되는 부분은 밑에서 올라와서 false, N-1도달하면 내리는 위치여서 false;
		for(int i = N-2 ; i > 0 ; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = false;
		robot[N-1] = false;
	}
	
	private static void moveRobot() {
		// 떨어지는위치 쪽이 올리는 위치보다 먼저 더 로봇이 올라갔으므로 뒤쪽을 먼저 옮겨야한다.
		for(int i = N-2 ; i >= 0 ; i--) {
			// 로봇이 있는 위치
			if(robot[i]) {
				// map배열 기준으로 left + i + 1
				// 로봇배열 기준으로 N-2
				int next = left + i + 1;
				if(next >= 2*N) next -= 2*N;
				
				if(!robot[i+1] && map[next] >=1) {
					robot[i] = false;
					if(i+1 < N-1) robot[i+1] = true;
					
					map[next] --;
					if(map[next] == 0) K--;
				}
			}
		}
	}
	
	private static void newRobot() {
		if(map[left] > 0) {
			robot[0] = true;
			map[left] --;
			if(map[left] == 0) K--;
		}
	}
}