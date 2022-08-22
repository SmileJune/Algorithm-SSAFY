package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Day197BOJ1034램프 {
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i] = br.readLine();
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String line = lines[i];
			int count = 0;
			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == '0') {
					count++;
				}
			}
			if (count <= k && count % 2 == k % 2) {
				map.put(line, map.getOrDefault(line, 0) + 1);
			}
		}
		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list);
		if (list.size() == 0) {
			bw.write("0\n");
		} else {
			bw.write(list.get(list.size() - 1) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
