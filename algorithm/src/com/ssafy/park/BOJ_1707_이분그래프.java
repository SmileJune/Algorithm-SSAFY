package com.ssafy.park;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {
	static int k;
	static int v, e;
	static Node[] nodes;
	static boolean[] visited;
	static boolean ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());
		while (k-- != 0) {
			st = new StringTokenizer(br.readLine());

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			nodes = new Node[v + 1];
			visited = new boolean[20001];

			for (int i = 1; i <= v; i++) {
				nodes[i] = new Node(i);
			}
			ans = true;

			int a, b;
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				nodes[a].child.add(nodes[b]);
				nodes[b].child.add(nodes[a]);
			}

			for (int i = 1; i <= v; i++) {
				if (!visited[i]) {
					visited[i] = true;
					nodes[i].setColor(1);
					if (!bfs(i)) {
						ans = false;
						break;
					}
				}
			}

			System.out.println(ans ? "YES" : "NO");

		}

	}

	static boolean bfs(int idx) {
		Queue<Node> q = new LinkedList<>();
		q.add(nodes[idx]);

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (check(node)) {
				return false;
			} else {
				for (Node child : node.child) {
					if (!visited[child.idx]) {
						visited[child.idx] = true;
						child.setColor(1 - node.color);
						q.add(child);
					}
				}
			}

		}
		return true;

	}

	static boolean check(Node node) {
		for (Node temp : node.child) {
			if (visited[temp.idx] && temp.color == node.color) {
				return true;
			}
		}
		return false;
	}

	static class Node {
		int idx;
		int color;

		ArrayList<Node> child = new ArrayList<>();

		public Node(int idx) {
			this.idx = idx;
		}

		public void setColor(int color) {
			this.color = color;
		}

	}

}