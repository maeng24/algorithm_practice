package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1449 {

	static PriorityQueue<Integer> tapes;
	static int N, L;

	//테이프가 몇 개 필요하는지 센다.
	public static int calctape(){
		
		int tapeend=tapes.poll()+L,answer=1;

		while(!tapes.isEmpty()){
			//테이프의 끝 길이안에 다음 구멍이 막아질 때
			if(tapeend>tapes.peek()){
				tapes.poll();
				
			}else{//새 테이프를 사용해야 할 때
				answer++;
				tapeend=tapes.poll()+L;
			}
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(tk.nextToken());
		L=Integer.parseInt(tk.nextToken());
		
		tapes=new PriorityQueue<>();
		
		tk=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			tapes.add(Integer.parseInt(tk.nextToken()));
		}
		
		System.out.println(calctape());
		
	}

}
