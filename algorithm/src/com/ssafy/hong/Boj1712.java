package com.ssafy.hong;
import java.util.*;

public class Boj1712 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(C > B) System.out.println(A/(C-B)+1);
		else System.out.println("-1");
		
	}
}
