package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_10815 {

	static int n, m;
	static int[] cards;
	
	//분할 정복법을 사용하여 탐색한다.
	public static int search(int num,int left, int right) {
		int result=0;
		if (left+1 < right ) {
			int center=(left+right)/2;
			if (cards[center] > num) {
				result=search(num,left,center);
			} else if (cards[center] < num) {
				result=search(num,center,right);
			} else {
				return 1;
			}
		}else if(left+1==right){
			if(cards[left]==num||cards[right]==num){
				return 1;
			}
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cards = new int[n];

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(tk.nextToken());
		}

		// cards정렬
		Arrays.sort(cards);
		
		m = Integer.parseInt(br.readLine());

		tk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			System.out.print(search(Integer.parseInt(tk.nextToken()),0, n - 1)+" ");
		}
		
	}

}
