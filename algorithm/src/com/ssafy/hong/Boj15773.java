package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15773 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		List<P> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			long l = Long.parseLong(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			list.add(new P(l+d,d));
		}
		list.sort((o1,o2)-> o1.f > o2.f ? 1 : -1);
		PriorityQueue<Long> pq = new PriorityQueue<>();
		Long curr = 0L;
		
		for(int i=0; i<N; i++) {
			pq.add(list.get(i).s);
			curr += list.get(i).s;
			
			while(curr > list.get(i).s) {
				curr -= pq.poll();
			}
		}
		
		System.out.println(pq.size());
	}  
	
	static class P{
		long f, s;
		P(long f, long s){this.f=f; this.s=s;}
	}
}
