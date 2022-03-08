package com.ssafy.ehoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 저번엔 LinkedList로 푼 거 같은데
// 이번엔 Queue로 풀어보자!
// 근데 그러려면 원형 큐로 풀어야겠지.. 기억이 잘 안나는데 ㅎ 

// 스트링 빌더 사용
public class Day29_BOJ_S4_11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
			
		sb.append('<');
		
		// 사람을 계속 나오라고 해 
		// 근데 걔가 K번째 애야
		// 그러면 다시 안 넣어, 안 넣으면 sb에 더해 
		// 아니면 다시 넣어! 
		
		while (q.size()!=1) {
			for (int i = 0; i < K-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", "); // k번째만 꺼내
		}
		// ", " 이거 떼고 넣어야 해서 마지막 남은 
		sb.append(q.poll()).append('>');
		System.out.println(sb);
		
		sc.close();
	}
}
