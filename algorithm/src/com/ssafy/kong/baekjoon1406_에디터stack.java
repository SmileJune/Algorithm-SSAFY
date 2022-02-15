package com.ssafy.algorithm;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Stack; 
public class backjoon1406_에디터stack { 
	public static void main(String[] args) throws Exception { 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine(); 
		int n = Integer.parseInt(bf.readLine());
		
		Stack<Character> leftStack = new Stack<>(); 
		Stack<Character> rightStack = new Stack<>(); 
		for (int i = 0; i < str.length(); i++) { 
			leftStack.push(str.charAt(i)); 
			} 
		while (n-- > 0) { 
			String[] line = bf.readLine().split(" "); 
			
			if (line[0].equals("L")) { 
				if(!leftStack.empty()){ 
					rightStack.push(leftStack.pop()); 
				} 
			} // 커서 오른쪽 한칸 이동 
			else if (line[0].equals("D")) { 
				if(!rightStack.empty()){ 
					leftStack.push(rightStack.pop()); 
				} 
			} // 커서 왼쪽 문자 삭제 
			else if (line[0].equals("B")) { 
				if(!leftStack.empty()){ 
					leftStack.pop(); 
				} 
			} 
			else if (line[0].equals("P")) { 
				leftStack.push(line[1].charAt(0)); 
			} 
		}
		StringBuilder sb = new StringBuilder(); 
		while(!leftStack.isEmpty()){ 
			rightStack.push(leftStack.pop()); 
		} 
		while(!rightStack.isEmpty()){ 
			sb.append(rightStack.pop()); 
		}
		System.out.println(sb); 
	} 
}
