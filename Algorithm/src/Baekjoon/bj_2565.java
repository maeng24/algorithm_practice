package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2565 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] line=new int[501];
		int num=Integer.parseInt(br.readLine());
		int[] connect=new int[501];
		for(int i=0;i<num;i++){
			StringTokenizer tk=new StringTokenizer(br.readLine()," ");
			line[Integer.parseInt(tk.nextToken())]=Integer.parseInt(tk.nextToken());
		}
		
		for(int i=1;i<501;i++){
			if(line[i]!=0){
				connect[i]=1;
				for(int j=i-1;j>0;j--){
					if(line[i]>line[j]){
						connect[i]=Math.max(connect[i], connect[j]+1);
					}
				}
			}
		}
		
		int answer=0;
		
		for(int i=0;i<501;i++){
			answer=Math.max(answer, connect[i]);
		}
			System.out.println(num-answer);
	}

}
