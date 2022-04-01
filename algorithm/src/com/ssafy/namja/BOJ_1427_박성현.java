package com.ssafy.namja;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1427_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String num = sc.nextLine();
		char[] nums = num.toCharArray();
		Arrays.sort(nums);
		
		for (int i = nums.length - 1; i >= 0; i--)
			System.out.print(nums[i]);
	}
}