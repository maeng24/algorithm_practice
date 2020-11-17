package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1963 {

	// false가 소수
	static boolean[] primenumber = new boolean[10000];

	public static void erasto() {

		for (int i = 2; i < 5000; i++) {
			if (primenumber[i] == false) {
				for (int j = 2; j < 5000; j++) {
					int n = i * j;
					if (n >= 10000) {
						break;
					} else {
						primenumber[n] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		erasto();

		for (int i = 0; i < n; i++) {
			Queue<String> passwords = new LinkedList<String>();
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			passwords.add(tk.nextToken());
			String answer = tk.nextToken();
			int ans = 0;
			boolean success = false;

			boolean[] visit = new boolean[10000];
			visit[Integer.parseInt(passwords.peek())] = true;
			
			//바꿀것과 바꾸기전이 같으면 바로 리턴
			if (answer.equals(passwords.peek())) {
				success = true;
			}
			
			//bfs로 구하기
			while (!passwords.isEmpty() && !success) {
				int len = passwords.size();
				ans++;
				for (int j = 0; j < len; j++) {
					String number = passwords.poll();
					for (int k = 0; k < 4; k++) {
						for (int l = 0; l < 10; l++) {
							String str = "";
							if (k == 0) {
								if (l == 0) {
									continue;
								} else {
									str = Integer.toString(l) + number.substring(1);
								}
							} else if (k == 3) {
								str = number.substring(0, 3) + Integer.toString(l);
							} else {
								str = number.substring(0, k) + Integer.toString(l) + number.substring(k + 1);
							}

							int next = Integer.parseInt(str);
							if (answer.equals(str)) {
								success = true;
								break;
							} else if (!primenumber[next] && !visit[next]) {
								visit[next] = true;
								passwords.add(str);
							}
						}
						if (success) {
							break;
						}
					}
					if (success) {
						break;
					}
				}
			}

			if (!success) {
				System.out.println("impossible");
			} else {
				System.out.println(ans);
			}
		}
	}

}
