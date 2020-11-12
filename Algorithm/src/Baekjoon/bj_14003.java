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
	
	//이분탐색으로 자리를 계산하는 함수
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
		index[i]=dest;// 이 인덱스에 해당 자리의 숫자가 바뀌었음을 의미
		checknumber[dest]=number;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		checknumber=new int[N];
		int[] numbers=new int[N];
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		//0번째 인덱스 넣기
		topnum=0;
		index=new int[N];
		index[0]=0;
		checknumber[topnum++]=Integer.parseInt(tk.nextToken());
		numbers[0]=checknumber[topnum-1];
		
		
		//1번째부터 계산한다.
		for(int i=1;i<N;i++){
			index[i]=i;
			int number=Integer.parseInt(tk.nextToken());
			numbers[i]=number;
			if(checknumber[topnum-1]<number){//맨 위 숫자보다 큰 수일 경우 넣어줌.
				index[i]=topnum;
				checknumber[topnum++]=number;
			}else{
				checkpos(number,i);//작으면 이분 탐색
			}
		}

		//뒤에서 부터 계산함으로써 가장 나중에 바뀐 결과만을 저장한다.
		int len=topnum-1;
		Stack<Integer> ans=new Stack<>();
		for(int i=N-1;i>=0;i--){
			if(index[i]==len){
				ans.push(numbers[i]);
				len--;
			}
		}
		
		//나중에 Stringbuilder를 써보자.
		System.out.println(topnum);
		while(!ans.isEmpty()){
			System.out.print(ans.pop()+" ");
		}

	}

}
