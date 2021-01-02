package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minheap=new PriorityQueue<>();
		
		for(int i=0;i<num;i++){
			int n=Integer.parseInt(br.readLine());
			if(n==0){
				if(minheap.isEmpty()){
					System.out.println(0);
				}else{
					System.out.println(minheap.poll());
				}
			}else{
				minheap.add(n);
			}
		}
	}

}
