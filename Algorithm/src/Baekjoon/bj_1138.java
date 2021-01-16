package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1138 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		int[] line=new int[num];
		int n=0;
		for(int i=0;i<num;i++){
			n=Integer.parseInt(tk.nextToken());
			//빈자리일때만
			for(int j=0;j<num;j++){
				if(n==0&&line[j]==0){
					line[j]=i+1;
					break;
				}else if(line[j]==0){//더 큰 수 가 들어올 수 있는 자리를 센다
					n--;
				}
			}
		}
		
		for(int i=0;i<num;i++){
			System.out.print(line[i]+" ");
		}

	}

}
