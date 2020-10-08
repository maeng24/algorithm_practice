package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		int[] numarray=new int[num];
		int[] sum=new int[num];
		
		for(int i=0;i<num;i++){
			numarray[i]=Integer.parseInt(tk.nextToken());
			sum[i]=numarray[i];
		}
		
		for(int i=1;i<num;i++){
			for(int j=0;j<i;j++){
				if(numarray[j]<numarray[i]){
					sum[i]=Math.max(sum[i], sum[j]+numarray[i]);
				}
			}
		}
		
		int answer=0;
		for(int i=0;i<num;i++){
			answer=Math.max(answer, sum[i]);
		}
		System.out.println(answer);
	}

}
