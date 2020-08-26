package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int peoplenum=Integer.parseInt(br.readLine());
		int[] times=new int[peoplenum];
		int answer=0;
		int waitingtime=0;
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<times.length;i++){
			times[i]=Integer.parseInt(tk.nextToken());
		}

		Arrays.sort(times);
	
		for(int i=0;i<times.length;i++){
			waitingtime+=times[i];
			answer+=waitingtime;
		}
		
		System.out.println(answer);
	}

}
