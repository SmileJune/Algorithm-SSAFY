package com.ssafy.park;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_11723_집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      StringBuilder sb = new StringBuilder();
	      int m = sc.nextInt();  
	      Set<Integer> set = new HashSet<>(); 
	      
	      for (int i = 0; i < m; i++) {
	         String cal = sc.next();
	         int x = 0;
	         
	         switch (cal) {
	            case "add" :
	               x = sc.nextInt();
	               set.add(x);
	               break;   
	            case "remove" :
	               x = sc.nextInt();
	               set.remove(x);
	               break;
	            case "check" :
	               x = sc.nextInt();
	               if (set.contains(x))
	                  sb.append("1\n");
	               else
	                  sb.append("0\n");
	               break;
	            case "toggle" :
	               x = sc.nextInt();
	               if (set.contains(x))
	                  set.remove(x);
	               else
	                  set.add(x);
	               break;   
	            case "all" :
	               for (int k = 0; k < 20; k++) {
	                  set.add(k + 1);
	               }
	               break;
	            case "empty" :
	               set.clear();
	               break;               
	         }
	      }
	      System.out.print(sb.toString());
	      sc.close();
	   }
	}