package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_12015 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		
		int number=0,top=0;
		ArrayList<Integer> lis=new ArrayList<>();
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		lis.add(Integer.parseInt(tk.nextToken()));
		
		//LIS 이분탐색을 이용해서 최장수열길이를 찾는다.
		for(int i=1;i<num;i++){
			number=Integer.parseInt(tk.nextToken());
			if(lis.get(top)<number){
				lis.add(number);
				top++;
			}else{
				for(int j=top-1;j>=0;j--){
					if(lis.get(j)<number){
						lis.set(j+1, number);
						break;
					}
				}
				if(lis.get(0)>number){
					lis.set(0,number);
				}
			}
		}
		
		System.out.println(top+1);
	}

}
