package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Day7BOJ1764듣보잡 { // 1764 듣보잡
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		while (N-- > 0) {
			String name = br.readLine();
			set.add(name);
		}
		while (M-- > 0) {
			String name = br.readLine();
			if (set.contains(name)) {
				list.add(name);
			}
		}
		Collections.sort(list);

		StringBuilder ans = new StringBuilder();
		ans.append(list.size()).append('\n');
		for (String str : list) {
			ans.append(str).append('\n');
		}

		System.out.println(ans);
		br.close();
	}
}
