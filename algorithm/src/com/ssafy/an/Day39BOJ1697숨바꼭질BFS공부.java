package com.ssafy.an;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day39BOJ1697숨바꼭질BFS공부 { // 1697 숨바꼭질 BFS로 풀어보기
	static int N, K;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈이 위치
		K = sc.nextInt(); // 동생의 위치
		visited = new int[100001];
		// 걷기 이동 X-1 , X+1 1초
		// 순간이동 2*X 1초
		// N에서 K로 이동하는 최소 시간 탐색
		System.out.println((N != K) ? bfs(N) : 0);

		sc.close();
	}

	private static int bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num] = 1;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < 3; i++) {
				int next = temp;
				if (i == 0) { // 뒤로 한칸
					next = temp - 1;
				} else if (i == 1) { // 앞으로 한칸
					next = temp + 1;
				} else if (i == 2) { // 2배로 점프
					next = temp * 2;
				}
				if (next == K) {
					return visited[temp];
				}
				if (next >= 0 && next < visited.length && visited[next] == 0) {
					q.add(next);
					visited[next] = visited[temp] + 1;
				}
			}
//			System.out.println(Arrays.toString(visited)); // 배열 크기 줄이고 단계 확인하기
		}
		return -1;
	}
}

// 5, 17을 입력 받았을 때 ---- () : 상위 노드, [] : 기방문 노드 
// 5에서 시작 이동 : 4,6,10
// -- 4에서 이동 : 3,(5),8
// ---- 3에서 이동 : 2,(4),[6]
// ------ 2에서 이동 : 1,(3),[4] -- x
// ---- 8에서 이동 : [7],9,16
// ------ 9에서 이동 : (8),[10],[18] -- x
// ------16에서 이동 : 15,17o -- return
// -- 6에서 이동 : (5),7,12
// ---- 7에서 이동 : (6),[8],14
// ------14에서 이동 : (13),15,28x
// ----12에서 이동 : 11,13,24x
// ------11에서 이동 : [10],(12),22x
// ------13에서 이동 : (12),[14],26x
// --10에서 이동 : 9,11,20x
// ---- 9에서 이동 : [8],(10),18
// ------18에서 이동 : 17o -- return
// ----11에서 이동 : (10),12,22x
