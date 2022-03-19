package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj11725 {
	static int[] par;
	static Node[] node;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		node = new Node[N];
		par = new int[N];
		for(int i=0; i<N; i++) {
			node[i] = new Node();
			node[i].v=i;
		}
		
		for(int i=0; i<N-1; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			node[s].link.add(node[e]);
			node[e].link.add(node[s]);
		}
		recur(0,-1);
		for(int i=1; i<N; i++)System.out.println(par[i]+1);
	}
	
	static void recur(int curr, int parent) {
		for(Node next : node[curr].link) {
			if(next.v == parent)continue;
			par[next.v]=curr;
			recur(next.v,curr);
		}
	}
	
	static class Node{
		List<Node> link = new ArrayList<>();
		int v;
	}
}
