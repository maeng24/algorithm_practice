package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_14003 {
	static int[] checknumber;
	static int[] index;
	static int topnum;
	
	public static void checkpos(int number,int i){
		int start=0;
		int dest=topnum-1;
		int mid=0;
		while(start<dest){
			mid = (start + dest) >>1;
			if(checknumber[mid]<number){
				start=mid+1;
			}else{
				dest=mid;
			}
		}
		index[i]=dest;
		checknumber[dest]=number;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		checknumber=new int[N];
		int[] numbers=new int[N];
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		topnum=0;
		index=new int[N];
		index[0]=0;
		checknumber[topnum++]=Integer.parseInt(tk.nextToken());
		numbers[0]=checknumber[topnum-1];
		
		for(int i=1;i<N;i++){
			index[i]=i;
			int number=Integer.parseInt(tk.nextToken());
			numbers[i]=number;
			if(checknumber[topnum-1]<number){
				index[i]=topnum;
				checknumber[topnum++]=number;
			}else{
				checkpos(number,i);
			}
		}

		int len=topnum-1;
		Stack<Integer> ans=new Stack<>();
		for(int i=N-1;i>=0;i--){
			if(index[i]==len){
				ans.push(numbers[i]);
				len--;
			}
		}
		
		System.out.println(topnum);
		while(!ans.isEmpty()){
			System.out.print(ans.pop()+" ");
		}

	}

}
