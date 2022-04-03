package com.ssafy.BOJ_BZ;
import java.util.Scanner;
 
public class BOJ_2869_달팽이는올라가고싶다 {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int up = in.nextInt();		// A
		int down = in.nextInt();	// B
		int length = in.nextInt(); 	// C
 
		int day = (length - down) / (up - down);
        
		// 나머지가 있을 경우 (잔여 블럭이 있을 경우)
		if ((length - down) % (up - down) != 0) {
			day++;
		}
		System.out.println(day);
	}
}