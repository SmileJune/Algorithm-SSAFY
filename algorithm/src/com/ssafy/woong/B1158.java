package com.ssafy.woong;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class B1158 {

	public static void main(String[] args) {
		String str = "";
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		while(q.size() >0) {
			
			for(int i = 0 ; i < k - 1; i++) {
				q.add(q.poll());
			}
			str += String.valueOf(q.poll());
			if(q.size() > 0) {
				str += ", ";
			}
		}
		
		System.out.println("<"+str+">");
		sc.close();
	}

}