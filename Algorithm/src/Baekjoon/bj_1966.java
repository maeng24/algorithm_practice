package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());

		for (int i = 0; i < tcase; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(tk.nextToken());
			int M = Integer.parseInt(tk.nextToken());

			int[] importance = new int[10];
			Queue<Integer> print = new LinkedList<>();
			int Mimp=0;

			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(tk.nextToken());
				print.add(num);
				importance[num]++;
				if(j==M){
					Mimp=num;
				}
			}
			
			// 현재 가장 중요도가 높은 일의 중요도를 저장
			int impcnt = 0;
			for (int j = 9; j > 0; j--) {
				if (importance[j] != 0) {
					impcnt = j;
					break;
				}
			}
			
			//중요도를 낮춰가며 중요도가 높은 일을 먼저 프린트한다.
			int cnt = 0;
			while (true) {
				int nowprint = print.poll();
				if (M != 0) {
					M--;
					if (impcnt == Mimp&&impcnt==nowprint) {
						cnt++;
						importance[impcnt]--;
					} else {
						if (impcnt == nowprint) {
							cnt++;
							importance[impcnt]--;
							if (importance[impcnt] == 0) {
								while(true){
									if(importance[impcnt]!=0){
										break;
									}else{
										impcnt--;
									}
								}
							}
						} else {
							print.add(nowprint);
						}
					}
				} else {
					M = print.size();
					if (impcnt == nowprint) {//현재 가장 중요한 중요도와 뽑아야하는 프린트의 중요도가 같을 경우 탈출
						cnt++;
						break;
					} else {
						print.add(nowprint);

					}
				}
			}

			System.out.println(cnt);
		}

	}

}
