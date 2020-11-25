package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1300 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		
		int left=1;
		int right=k;
		int answer=0;
		
		while(left<=right){
			int mid=(left+right)/2;
			long sum=0;
			for(int i=1;i<=n;i++){
				sum+=Math.min(n, mid/i);
			}
			if(sum<k){
				left=mid+1;
			}else{
				answer=mid;
				right=mid-1;
			}
		}
		System.out.println(answer);
	}

}
