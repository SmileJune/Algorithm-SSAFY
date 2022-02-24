package com.ssafy.hong;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Boj17225{
	/**
	 * [BOJ: 17225] 세훈이의 선물가게
	 * 상민 - 파란 포장
	 * 지수 - 빨간 포장
	 * 원하는 포장 색깔별로 맞는 사람에게 선물 포장 업무 배정
	 * 상민이와 지수가 상품 1개 포장하는데는 각각 A초, B초가 소요되고,
	 * i번째 선물 포장 주문은 t_i초에 들어 온다.  
	 * 짬 상민>지수여서 동시에 포장을 하게 될 때, 상품을 상민이가 먼저 포장한다.
	 * 상민이와 지수가 어떤 제품들을 포장했는지 출력하시오.
	 * 
	 * input:	A B N	상민 시간, 지수 시간, 선물 주문 수
	 * 			t C n	주문 시간, 포장 색상, 상품 수
	 * 			..
	 * output:	a		상민이 포장한 상품 수
	 * 			a1 a2..	상민이 포장한 상품 번호
	 * 			b		지수가 포장한 상품 수
	 * 			b1 b2..	지수가 포장한 상품 번호
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		
		PriorityQueue<P> pq = new PriorityQueue<>((o1,o2)->{
			if(o1.time==o2.time)return o1.color-o2.color;
			return o1.time-o2.time;
		});
		
		Queue<Box> blue = new LinkedList<>();
		Queue<Box> red = new LinkedList<>();
		for(int i=0; i<N; i++) {
			int time = sc.nextInt();
			if(sc.next().charAt(0)=='B') {
				blue.add(new Box(time, sc.nextInt()));
			}
			else {
				red.add(new Box(time, sc.nextInt()));
			}
		}
		int n = 0, time = 0;
		int endA=blue.peek().time, endB=red.peek().time;
		blue.peek().cnt--; red.peek().cnt--;
		
		pq.add(new P(endA, 0));
		pq.add(new P(endB, 1));
		while(!pq.isEmpty()) {
			P curr = pq.poll();
			if(curr.color==0) {
				endA = curr.time + A;
				a.add(++n);
				if(!blue.isEmpty()) {
					if(blue.peek().cnt-- > 0) {
						time = endA >= blue.peek().time? endA:blue.peek().time;
						pq.add(new P(time, 0));
					}
					if(blue.peek().cnt==0)blue.poll();
				}
			}
			else {
				endB = curr.time + B;
				b.add(++n);
				if(!red.isEmpty()) {
					if(red.peek().cnt--> 0) {
						time = endB >= red.peek().time? endB:red.peek().time;
						pq.add(new P(time, 1));
					}
					if(red.peek().cnt==0)red.poll();
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append(a.size()).append('\n');
		for(int nn : a)sb.append(nn).append(' ');
		sb.append('\n');
		sb.append(b.size()).append('\n');
		for(int nn : b)sb.append(nn).append(' ');
		sb.append('\n');
		System.out.print(sb);
		
	}
	static class Box{
		int time, cnt;
		Box(int time, int cnt){this.time=time;this.cnt=cnt;}
	}
	static class P{
		int time, color;
		P(int time, int color){this.time=time;this.color=color;}
	}
	
}
