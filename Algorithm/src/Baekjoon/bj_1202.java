package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1202 {

	static class jewel implements Comparable<jewel>{
		int weight;
		int value;
		
		public jewel(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(jewel o) {
			// TODO Auto-generated method stub
			return weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		int N=Integer.parseInt(tk.nextToken());
		int K=Integer.parseInt(tk.nextToken());

		ArrayList<jewel> jewels=new ArrayList<>();
		for(int i=0;i<N;i++){
			tk=new StringTokenizer(br.readLine()," ");
			
			jewels.add(new jewel(Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())));
		}
		
		int[] bag=new int[K];
		for(int i=0;i<K;i++){
			bag[i]=Integer.parseInt(br.readLine());
		}
		//보석과 가방 무게 정렬
		Arrays.sort(bag);
		Collections.sort(jewels);

		long answer=0;
		PriorityQueue<Integer> values=new PriorityQueue<>();
		int weight=0;
		
		//들어가지 않은 보석과 가방의 무게를 비교해서 넣는다.
		for(int i=0;i<K;i++){
			for(int j=weight;j<N;j++){
				if(bag[i]>=jewels.get(j).weight){
					values.add(-jewels.get(j).value);
					weight++;
				}else{
					break;
				}
			}
			//들어갈 수 있는 보석중 가치가 큰 것 부터 하나씩 뺀다.
			if(!values.isEmpty()){
				answer+=-values.poll();
			}
		}
		
		System.out.println(answer);
	}

}
