package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14002 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int len=Integer.parseInt(br.readLine());
		
		int[] number=new int[len];
		int[] answer=new int[len];
		String[] answers=new String[len];
		int result=0,longest=0;
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<len;i++){
			number[i]=Integer.parseInt(tk.nextToken());
		}
		
		//최장 거리 수열 구하기
		for(int i=0;i<len;i++){
			answer[i]=1;
			answers[i]=Integer.toString(i)+",";
			for(int j=0;j<i;j++){
				if(number[j]<number[i]&&answer[j]+1>answer[i]){
					answer[i]=answer[j]+1;
					answers[i]=answers[j]+Integer.toString(i)+",";//최장 거리 수열의 인덱스를 저장
				}
			}
			if(longest<answer[i]){
				result=i;
				longest=answer[i];
			}
		}
		
		//인덱스를 새 배열에 나누어 저장
		String[] results=answers[result].split(",");
		int l=results.length;
		
		System.out.println(l);
		for(int i=0;i<l;i++){//인덱스의 값들을 차례로 출력
			System.out.print(number[Integer.parseInt(results[i])]+" ");
		}
	}

}
