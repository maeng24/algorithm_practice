package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1715 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> cards = new PriorityQueue<>();
		
		for (int i = 0; i < num; i++) {
			cards.add(Integer.parseInt(br.readLine()));
		}

		long answer=0;
				
		for(int i=0;i<num-1;i++){
			int card1=cards.poll();
			int card2=cards.poll();
			cards.add(card1+card2);
			answer+=card1+card2;
		}
		
		System.out.println(answer);
	}

}
