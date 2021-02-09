package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class bj_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> minheap=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxheap=new PriorityQueue<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++){
			
			if(i%2==0){
			maxheap.add(Integer.parseInt(br.readLine()));
			}else{
				minheap.add(Integer.parseInt(br.readLine()));
			}
			
			//최소힙과 최대힙의 앞 순서 숫자 swap 해주기
			if(!minheap.isEmpty()&&!maxheap.isEmpty()&&maxheap.peek()<minheap.peek()){
				int tmp=minheap.poll();
				minheap.add(maxheap.poll());
				maxheap.add(tmp);
			}
			
			//짝수일 경우에는 작은 수를 말한다.
			if(maxheap.size()>minheap.size()){
				bw.write(maxheap.peek()+"\n");
			}else{
				bw.write(minheap.peek()+"\n");
			}
		}
		bw.flush();
	}

}
