package com.ssafy.SWEA_SW모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2477_차량정비소 {
	static class Person {
		int arriveTime; // 도착시간
		int recption; // 접수 창구 번호
		int repair; // 수리 창구 번호
		int num;

		public Person(int num, int arriveTime) {
			this.num = num;
			this.arriveTime = arriveTime;
		}

	}

	static class Service {
		Person p;
		int num;
		int time;

		public Service(int num) {
			this.num = num;
		}
	}

	static int N, M, K, A, B;
	static int[] recT, repT; // 접수 시간, 수리시간, 클라이언트 오는 시간
	static Person[] client;
	static Service[] rec, rep; // 사람 있는지?
	static int ans, end, time;
	static Queue<Person> recP;
	static Queue<Person> repP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			end = 0;
			ans = 0;
			time = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 접수 창구의 개수
			M = Integer.parseInt(st.nextToken()); // 정비 창구의 개수
			K = Integer.parseInt(st.nextToken()); // 차량 정비소를 방문한 고객의 수
			A = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 접수 창구 번호
			B = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 정비 창구 번호
			recT = new int[N];
			rec = new Service[N];
			repT = new int[M];
			rep = new Service[M];
			client = new Person[K];
			recP = new LinkedList<>(); // 접수 기다리는 사람
			repP = new LinkedList<>(); // 수리 기다리는 사람
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				recT[i] = Integer.parseInt(st.nextToken());
				rec[i] = new Service(i + 1);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; ++i) {
				repT[i] = Integer.parseInt(st.nextToken());
				rep[i] = new Service(i + 1);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; ++i) {
				client[i] = new Person(i + 1, Integer.parseInt(st.nextToken()));
			}

			// 입력완료

			solution();// 문제풀기~!
			if (ans == 0) {
				ans = -1;
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void solution() {
		int idx = 0;
		while (true) {
			// 1. 정비소에서 나오는분~
			for (int i = 0; i < M; ++i) {
				if (rep[i].p != null) { // 만약 들어있으면
					rep[i].time--; // 1초씩 줄여주자.
					if (rep[i].time == 0) {
						Person tmp = rep[i].p;
						rep[i].p = null; // 사람 빼융
						end++;
						if (!repP.isEmpty()) { // 기다리는 사람이 있다면?
							rep[i].p = repP.remove();
							rep[i].p.repair = rep[i].num;
							rep[i].time = repT[i];
						}
						if (tmp.recption == A && tmp.repair == B) {
							ans += tmp.num;
						}

					}
				}
			}
			goRepair();
			if (end == K) {
				break;
			}
			// 2. 접수소에서 나오는 분~
			for (int i = 0; i < N; ++i) {
				if (rec[i].p != null) { // 만약 들어있으면
					rec[i].time--; // 1초씩 줄여주자.
					if (rec[i].time == 0) {
						Person tmp = rec[i].p;
						rec[i].p = null; // 사람 빼융
						if (!recP.isEmpty()) { // 기다리는 사람이 있다면?
							rec[i].p = recP.remove();
							rec[i].p.recption = rec[i].num;
							rec[i].time = recT[i];
						}
						// 0이 되었다는 것은 정비소로 가는 친구가 한명 늘었다는 것.
						repP.add(tmp);
					}
				}
			}
			goRepair();

			for (int i = idx; i < K; ++i) {
				if (client[i].arriveTime == time) {// 손님 도착 시간이 지금시간과 같으면
					for (int j = 0; j < N; ++j) {
						if (rec[j].time == 0) {
							rec[j].time = recT[j];
							client[i].recption = rec[j].num;
							rec[j].p = client[i];
							break;
						}
						if (j == N - 1) {
							// 만약에 끝까지 갔는데 빈 자리가 없으면 기다려야되잖어.
							recP.add(client[i]);
						}
					}
					idx++;
				} else { // 도착시간이 지금 시간과 같지않으면 걍 break 시켜도됨
					break;
				}
			} // 들어가기.

			time++;
		}

	}

	private static void goRepair() {
		for (int i = 0; i < M; ++i) {
			if (rep[i].p == null) {

				if (!repP.isEmpty()) {
					rep[i].time = repT[i];
					rep[i].p = repP.remove();
					rep[i].p.repair = rep[i].num;
				}
			}
		}
	}

}