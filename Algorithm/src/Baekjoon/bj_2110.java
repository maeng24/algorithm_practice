package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2110 {

	public static int N, C;
	public static int[] houses;
	
	public static int checkdistance(int left, int right) {
		int answer=0;
		int mid=0;
		
		while(left<=right){
			mid=(left+right)/2;
			
			int number=C;
			int gap=mid;
			int start=houses[0];
			number--;
			
			for(int i=1;i<N;i++){
				gap=houses[i]-start;
				if(gap>=mid){
					start=houses[i];
					number--;
				}
			}
			
			if(number<=0){
				answer=Math.max(mid, answer);
				left=mid+1;
			}else{
				right=mid-1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		houses = new int[N];

		for (int i = 0; i < N; i++) {
			houses[i] = sc.nextInt();
		}

		Arrays.sort(houses);

		System.out.println(checkdistance(0,houses[N-1]));
	}

}
