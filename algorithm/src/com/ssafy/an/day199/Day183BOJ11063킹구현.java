package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Day183BOJ11063킹구현 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rawData = br.readLine().split(" ");
		int kx = rawData[0].charAt(0) - 'A';
		int ky = rawData[0].charAt(1) - '1';
		int sx = rawData[1].charAt(0) - 'A';
		int sy = rawData[1].charAt(1) - '1';
		int movenum = Integer.parseInt(rawData[2]);
		Map<Character, int[]> moveDic = new HashMap<>();
		int[] moveB = { -1, 0 };
		moveDic.put('B', moveB);
		int[] moveL = { 0, -1 };
		moveDic.put('L', moveL);
		int[] moveR = { 0, 1 };
		moveDic.put('R', moveR);
		int[] moveT = { 1, 0 };
		moveDic.put('T', moveT);
		for (int i = 0; i < movenum; i++) {
			String rawMove = br.readLine();
			int moveX = 0;
			int moveY = 0;
			for (int j = 0; j < rawMove.length(); j++) {
				int[] moveTemp = moveDic.get(rawMove.charAt(j));
				moveX += moveTemp[1];
				moveY += moveTemp[0];
			}
			if (kx + moveX >= 0 && kx + moveX < 8 && ky + moveY >= 0 && ky + moveY < 8) {
				if (sx == kx + moveX && sy == ky + moveY) {
					if (sx + moveX >= 0 && sx + moveX < 8 && sy + moveY >= 0 && sy + moveY < 8) {
						sx += moveX;
						sy += moveY;
						kx += moveX;
						ky += moveY;
					}
				} else {
					kx += moveX;
					ky += moveY;
				}
			}
		}
		System.out.print((char) (kx + 'A'));
		System.out.println((int) (ky + 1));
		System.out.print((char) (sx + 'A'));
		System.out.println((int) (sy + 1));
	}
}
