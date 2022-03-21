package com.ssafy.namja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1655_박성현 {
	/* ------ How to Solve -------
	Running Median
	1. 우선순위 큐 lower, higher 두 개를 둔다.
	2. 처음에는 lower에 넣되, 그 후로는 lower의 front보다 크면 higher에, 작으면 lower에 넣는다.
	3. (lower : front 기준으로 내림차순 정렬 / higher : lower의 front보다 큰 수들을 오름차순 정렬)
	4. higher의 노드의 갯수가 lower의 노드의 갯수보다 1개가 더 많을때는 higher의 front를 lower로 보낸다.
	5. lower의 노드의 갯수가 higher의 노드의 갯수보다 2개가 더 많을때는 lower의 front를 higher로 보낸다.
	6. 매 반복마다 lower의 front를 출력한다.
	
	  ----------------------------*/
	
	static int[] lower;
	static int[] higher;
	static int size_lower;
	static int size_higher;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		
		lower = new int[N + 1];
		higher = new int[N + 1];
		
		//int first = sc.nextInt();
		int first = Integer.parseInt(br.readLine());
		push_low(first);
		//System.out.println(peek());
		bw.write(peek() + "\n");
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			//int num = sc.nextInt();
			if (num > first)
				push_high(num);
			else
				push_low(num);
			
			if (size_lower >= size_higher + 2) {
				push_high(pop_low());
				first = peek();
			}
			else if (size_higher >= size_lower + 1) {
				push_low(pop_high());
				first = peek();
			}
//			System.out.println(peek());
			bw.write(peek() + "\n");
		}
		bw.flush();
	}
	
	static void push_low(int num) {
		int i = ++size_lower;
		while(i != 1 && num > lower[i / 2]) {
			lower[i] = lower[i / 2];
			i /= 2;
		}
		lower[i] = num;
	}
	
	static void push_high(int num) {
		int i = ++size_higher;
		while(i != 1 && num < higher[i / 2]) {
			higher[i] = higher[i / 2];
			i /= 2;
		}
		higher[i] = num;
	}
	
	static int pop_low() {
		int front, temp, parent, child;
		front = lower[1];
		temp = lower[size_lower--];
		parent = 1;
		child = 2;
		
		while (child <= size_lower) {
			if (lower[child] <= lower[child + 1])
				child++;
			if (lower[child] <= temp)
				break;
			lower[parent] = lower[child];
			parent = child;
			child *= 2;
		}
		lower[parent] = temp;
		return front;
	}
	
	static int pop_high() {
		int front, temp, parent, child;
		front = higher[1];
		temp = higher[size_higher--];
		parent = 1;
		child = 2;
		
		while (child <= size_higher) {
			if (higher[child] >= higher[child + 1])
				child++;
			if (higher[child] >= temp)
				break;
			higher[parent] = higher[child];
			parent = child;
			child *= 2;
		}
		higher[parent] = temp;
		return front;
	}
	
	static int peek() {
		return lower[1];
	}
	
	static boolean isEmpty() {
		return size_lower == 0 ? true : false;
	}
}