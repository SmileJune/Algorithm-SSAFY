package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj1967 {
	static Node[] node;
	static int root=0, distance=0;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		node = new Node[N];
		for(int i=0; i<N; i++) {
			node[i] = new Node();
			node[i].no = i;
		}
		
		for(int i=0; i<N-1; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int d = sc.nextInt();
			
			node[s].children.add(node[e]);
			node[e].children.add(node[s]);
			node[s].dist.add(d);
			node[e].dist.add(d);
		}
		
		recur(0,-1,0);
		recur(root,-1,0);
		System.out.println(distance);
	}
	static void recur(int curr, int par, int dist) {
		if(distance < dist) {
			distance = dist;
			root = curr;
		}
		List<Node> list = node[curr].children;
		for(int i=0; i<list.size(); i++) {
			Node next = list.get(i);
			if(next.no == par)continue;
			recur(next.no, curr, dist + node[curr].dist.get(i));
		}
		
	}
	static class Node{
		int no;
		List<Integer> dist = new ArrayList<>();
		List<Node> children = new ArrayList<>();
	}
}
