package com.ssafy.park;

import java.util.Scanner;

public class BOJ_11060_점프점프 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int[] a = new int[n];
	        int[] dist = new int[n];
	        for (int i=0; i<n; i++) {
	            a[i] = sc.nextInt();
	            dist[i] = -1;
	        }
	        dist[0] = 0;
	        for (int i=1; i<n; i++) {
	            for (int j=0; j<i; j++) {
	                if (dist[j] != -1 && i-j <= a[j]) {
	                    if (dist[i] == -1 || dist[i] > dist[j] + 1) {
	                        dist[i] = dist[j] + 1;
	                    }
	                }
	            }
	        }
	        System.out.println(dist[n-1]);
	    }
	}