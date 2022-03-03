package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2941 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();

		str = str.replaceAll("c=", "a");
		str = str.replaceAll("c-", "a");
		str = str.replaceAll("dz=", "a");
		str = str.replaceAll("d-", "a");
		str = str.replaceAll("lj", "a");
		str = str.replaceAll("nj", "a");
		str = str.replaceAll("s=", "a");
		str = str.replaceAll("z=", "a");

		System.out.println(str.length());

	}

}
