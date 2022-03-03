package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Deque deque = new Deque();
		for(int i = 0 ; i < n; i++) {
			String[] str = br.readLine().split(" ");
			
			if(str[0].equals("push_back")) {
				deque.push_back(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("push_front")) {
				deque.push_front(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("pop_back")) {
				System.out.println(deque.pop_back());
			}
			else if(str[0].equals("pop_front")) {
				System.out.println(deque.pop_front());
			}
			else if(str[0].equals("size")) {
				System.out.println(deque.size());
			}
			else if(str[0].equals("empty")) {
				System.out.println(deque.empty());
			}
			else if(str[0].equals("front")) {
				System.out.println(deque.front());
			}
			else if(str[0].equals("back")) {
				System.out.println(deque.back());
			}
			
		}
	}

}

class Deque{
	
	int front;
	int rear;
	LinkedList<Integer> queue = new LinkedList<>();
	
	void push_front(int item) {
		queue.addFirst(item);
	}
	
	void push_back(int item) {
		queue.addLast(item);
	}
	
	int pop_front() {
		if(empty() == 1) {
			return -1;
		}
		return queue.remove();
	}
	
	int pop_back() {
		if(empty() == 1) {
			return -1;
		}
		return queue.removeLast();
	}
	
	int size() {
		return queue.size();
	};
	
	int empty() {
		if(queue.isEmpty()) {
			return 1;
		}return 0;		
	}
	
	int front() {
		if(empty() == 1) {
			return -1;
		}
		return queue.peek();
	}
	
	int back() {
		if(empty() == 1) {
			return -1;
		}
		return queue.peekLast();
	}
	
}