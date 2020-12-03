package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Conference implements Comparable<Conference> {
	public int start;
	public int end;

	public Conference() {
	}

	public Conference(int start, int end) {
		this.start = start;
		this.end = end;
	}

	//도착시간 기준 오름차
	@Override
	public int compareTo(Conference o) {
		// TODO Auto-generated method stub
		
		if(end-o.end==0){
			return start-o.start;
		}
		return end - o.end;
	}

}

public class bj_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		ArrayList<Conference> con = new ArrayList<>();
		StringTokenizer tk = null;
		
		for (int i = 0; i < num; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			con.add(new Conference(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken())));
		}
		
		//오름차로 정렬
		Collections.sort(con);
		
		//시작시간이 도착보다 느릴경우 도착시간 교체
		int answer = 0;
		int endtime = -1;
		for (int i = 0; i < num; i++) {
			if (endtime <= con.get(i).start) {
				answer++;
				endtime = con.get(i).end;

			}
		}

		System.out.println(answer);
	}

}
