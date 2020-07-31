package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		int[] set=new int[num]; // ����
		int[] len=new int[num]; // ���� �� �κ� ���� ���ϱ�
		int answer=0;
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<num;i++){
			set[i]=Integer.parseInt(tk.nextToken());
		}
		
		len[0]=1;
		
		//���� �� �κ� ���� ���ϱ�
		for(int i=1;i<num;i++){
			len[i]=1;
			for(int t=i-1;t>=0;t--){
				if(set[i]>set[t]){
					len[i]=Math.max(len[i], len[t]+1);
				}
			}
		}
		
		//���� �� ������ ����
		for (int i=0;i<num;i++){
			answer=Math.max(answer, len[i]);
		}
		
		System.out.println(answer);
	}

}
