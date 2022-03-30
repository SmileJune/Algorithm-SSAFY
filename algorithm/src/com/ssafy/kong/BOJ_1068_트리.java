package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1068_트리 {
	static class Node {
		List<Integer> child = new ArrayList<Integer>();
		int top = -1;
		int self = -1;
		boolean isLif = true;
	}

	static Node[] node;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		node = new Node[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			node[i] = new Node();
			node[i].self = i;
		}
		for (int i = 0; i < N; ++i) {
			int val = Integer.parseInt(st.nextToken());
			node[i].top = val;
			if (val >= 0) {
				node[val].child.add(i);
				node[val].isLif = false;
			}
		}
		int del = Integer.parseInt(br.readLine());
		int t = node[del].top;
		delete(del);
		if (t >= 0) {
			for (int i = 0; i < node[t].child.size(); ++i) {
				if (node[t].child.get(i) == del) {
					node[t].child.remove(i);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; ++i) {
			if (node[i].top != -2 && (node[i].child.size() == 0)) {
				ans++;
			}
		}
		System.out.print(ans);
	}// main

	static void delete(int idx) {
		node[idx].top = -2;
		// top을 그냥 끊어버릴거얌
		if (node[idx].child.size() > 0) {
			for (int i = 0; i < node[idx].child.size(); ++i) {
				delete(node[idx].child.get(i));
			}
		}
	}
}
