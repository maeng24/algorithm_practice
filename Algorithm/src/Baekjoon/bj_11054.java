package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		int len=Integer.parseInt(br.readLine());
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		int arr[]=new int[len+2];
		int ans[]=new int[len+2];
		for(int i=0;i<len;i++){
			arr[i]=Integer.parseInt(tk.nextToken());
		}
		
		//���� �� �κ� ������� ���� ���ϱ�
		//�ʱⰪ
		ans[0]=1;
		if(arr[1]>arr[0]){
			ans[1]=2;
		}else{
			ans[1]=1;
		}
		
		//���ڰ� �ö󰡴� �κм��� ���ϱ�
		for(int i=2;i<len;i++){
			ans[i]=1;
			for(int j=i-1;j>=0;j--){
				if(arr[j]<arr[i]){
					ans[i]=Math.max(ans[j]+1, ans[i]);
				}
			}
		}
		
		//�������� ���� �κм��� ���ϱ�
		for(int i=2;i<len;i++){
			for(int j=i-1;j>=0;j--){
				if(arr[j]>arr[i]){
					ans[i]=Math.max(ans[j]+1, ans[i]);
				}
			}
		}
		
		int answer=0;
		for(int i=0;i<len;i++){
			answer=Math.max(ans[i], answer);
		}
		
		System.out.println(answer);
	}

}
