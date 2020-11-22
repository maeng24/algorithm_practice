package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11722 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		int[] answer=new int[num];
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		answer[0]=Integer.parseInt(tk.nextToken());
		int n=0;
		//감소하는 부분 수열 구하기
		for(int i=1;i<num;i++){
			int number=Integer.parseInt(tk.nextToken());
			if(number<answer[n]){//지난 수열 보다 작으면 다음 인덱스에 저장.
				answer[n+1]=number;
				n++;
			}else {//아니면 맞는 위치에 저장한다.
				for(int j=0;j<=n;j++){
					if(answer[j]<number){
						answer[j]=number;
						break;
					}else if(answer[j]==number){
						break;
					}
				}
			}
		}
		System.out.println(n+1);

	}

}
