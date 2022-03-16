package com.ssafy.yun.Baek;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
	String name;
	int a;
	int b;
	int c;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int a, int b, int c) {
		super();
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}

}

public class Baek_10825 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.a == o2.a && o1.b == o2.b && o1.c == o2.c) {
					return o1.name.compareTo(o2.name);
				}

				if (o1.a == o2.a && o1.b == o2.b) {
					return o2.c - o1.c;
				}

				if (o1.a == o2.a) {
					return o1.b - o2.b;
				}
				return o2.a - o1.a;
			}

		});
		
		for(Student student : list) {
			System.out.println(student.name);
		}

	}

}
