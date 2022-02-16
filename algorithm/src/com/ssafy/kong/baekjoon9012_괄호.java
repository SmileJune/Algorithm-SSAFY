package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon9012_괄호{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		outer : for(int t = 0; t < n; ++t) {
			Stack<Character> bracket = new Stack<>();
			String str = br.readLine();
			
			for(int i = 0; i < str.length(); ++i) {
				if( str.charAt(i) =='(' ) {
					bracket.push(str.charAt(i));
				}
				else {
					if(!bracket.isEmpty()) {
						bracket.pop();
					}else {
						System.out.println("NO");
						continue outer;
					}
				}
				
			}
			if(bracket.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
	}
}