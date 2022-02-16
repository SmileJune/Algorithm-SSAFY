package com.ssafy.kong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//1부터 n까지에 수에 대해 차례로 [push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop] 연산을 수행하면 수열 [4, 3, 6, 8, 7, 5, 2, 1]을 얻을 수 있다.

public class baekjoon1874_스택수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> num = new Stack<>();
		StringBuilder sb = new StringBuilder();
		num.push(0);
		int index = 0;
		for( int i = 0; i < n; ++i ) {
			int input = Integer.parseInt(br.readLine());
			if(  input >= num.peek()) {
				for(index = index+1 ; input > num.peek(); ++index){
					num.push(index);
					sb.append("+").append("\n");
				}
				num.pop();
				index--;
				sb.append("-").append("\n");
			}
			else {
				for(index = index-1 ; input < num.peek(); --index){
					num.pop();
					sb.append("-").append("\n");
				}
			}
		}
		num.pop();
		if(!num.isEmpty())
			System.out.println("NO");
		else
			System.out.println(sb);
	}
}