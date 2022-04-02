package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217_로프 {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	        int cnt = Integer.parseInt(br.readLine());
	        int arr[] = new int[cnt];
	        for(int i=0; i < cnt; i++) {
	  
	            arr[i] = Integer.parseInt(br.readLine());
	        }
	        Arrays.sort(arr);
	        
	        long max = 0;
	        for(int i = cnt-1; i >= 0; i--) {
	            arr[i] = arr[i] * (cnt-i);
	            if(max < arr[i]) max = arr[i];
	        }
	        System.out.println(max);
	    }
	}
