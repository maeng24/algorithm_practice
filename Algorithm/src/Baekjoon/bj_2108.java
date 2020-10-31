package Baekjoon;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		PriorityQueue<Integer> numbers = new PriorityQueue<>();
		HashMap<Integer, Integer> modecalc = new HashMap<>();

		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			numbers.add(n);
			modecalc.put(n, modecalc.getOrDefault(n, 0) + 1);
		}
		
		double avg=0;
		int range=0,moden=0,medium=0,mode=0;
		PriorityQueue<Integer> modes=new PriorityQueue<>();
		int m=num/2;
		int l=num-1;
		
		for(int i=0;i<num;i++){
			int n=numbers.poll();
			//중앙값과 범위
			if(i==m){
				medium=n;
			}else if(i==0){
				range+=n;
			}else if(i==l){
				range=Math.abs(range-n);
			}
			
			//최빈값
			if(modecalc.containsKey(n)&&moden<modecalc.get(n)){
				moden=modecalc.get(n);
				modes=new PriorityQueue<>();
				modes.add(n);
				modecalc.remove(n);
			}else if(modecalc.containsKey(n)&&moden==modecalc.get(n)){
				modes.add(n);
			}
			//평균
			avg+=n;
		}
		avg=Math.round(avg/num);
		if(modes.size()>1){
			modes.poll();
		}
		mode=modes.poll();
		
		System.out.println((int)avg+"\n"+medium+"\n"+mode+"\n"+range);

	}

}
