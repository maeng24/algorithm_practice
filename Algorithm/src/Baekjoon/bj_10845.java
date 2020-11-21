package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		Deque<Integer> queue=new LinkedList<Integer>();
		
		for(int i=0;i<num;i++){
			StringTokenizer tk=new StringTokenizer(br.readLine()," ");
			String order=tk.nextToken();
			switch (order) {
			case "push":
				queue.add(Integer.parseInt(tk.nextToken()));
				continue;
			case "pop":
				if(queue.isEmpty()){
				System.out.println("-1");
			}else{
				System.out.println(queue.pollFirst());
			}
				continue;
			case "size":
				System.out.println(queue.size());
				continue;
			case "empty":
				if(queue.isEmpty()){
					System.out.println("1");
				}else{
					System.out.println("0");
				}
				continue;
			case "front":
				if(queue.isEmpty()){
					System.out.println("-1");
				}else{
					System.out.println(queue.peekFirst());
				}
				continue;
			case "back":
				if(queue.isEmpty()){
					System.out.println("-1");
				}else{
					System.out.println(queue.peekLast());
				}
				continue;

			default:
				continue;
			}
		}

	}

}
