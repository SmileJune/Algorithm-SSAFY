package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5639_이진검색트리 {
	static class Node {
		Node left;
		Node right;
		int self;

		Node(int self) {
			this.self = self;
		}

		void insert(int n) {
			if (n < this.self) {
				if (this.left == null)
					this.left = new Node(n);
				else
					this.left.insert(n);
			} else {
				if (this.right == null)
					this.right = new Node(n);
				else
					this.right.insert(n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node node = new Node(Integer.parseInt(br.readLine()));
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			node.insert(Integer.parseInt(input));
		}
		postOrder(node);
	}

	static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.self);
	}

}
