package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj1991 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Node[] node =new Node[N];
		for(int i=0; i<N; i++) {
			node[i] = new Node();
			node[i].v=(char)(i+'A');
		}
		
		for(int i=0; i<N; i++) {
			char p  = sc.next().charAt(0);
			char l  = sc.next().charAt(0);
			char r  = sc.next().charAt(0);
			if(l != '.')node[p-'A'].l=node[l-'A'];
			if(r != '.')node[p-'A'].r=node[r-'A'];
		}
		preorder(node[0]);
		System.out.println();
		midorder(node[0]);
		System.out.println();
		postorder(node[0]);
	}
	
	static void preorder(Node curr) {
		System.out.print(curr.v);
		if(curr.l != null)preorder(curr.l);
		if(curr.r != null)preorder(curr.r);
	}
	static void midorder(Node curr) {
		if(curr.l != null)midorder(curr.l);
		System.out.print(curr.v);
		if(curr.r != null)midorder(curr.r);
	}
	static void postorder(Node curr) {
		if(curr.l != null)postorder(curr.l);
		if(curr.r != null)postorder(curr.r);
		System.out.print(curr.v);
	}
	
	static class Node{
		Node l, r;
		char v;
	}
}
