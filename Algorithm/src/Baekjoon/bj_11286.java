package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class number_11286 implements Comparable<number_11286> {
	private int n;
	private int abs_n;

	public number_11286(int n) {
		this.n = n;
		if (n > 0) {
			this.abs_n = n;
		} else {
			this.abs_n = -n;
		}
	}

	public int getN() {
		return n;
	}

	public int getAbs_n() {
		return abs_n;
	}

	public void setN(int n) {
		this.n = n;
		if (n > 0) {
			this.abs_n = n;
		} else {
			this.abs_n = -n;
		}
	}

	//절댓값 -> 값 순으로 정렬
	@Override
	public int compareTo(number_11286 o) {
		// TODO Auto-generated method stub
		if (o.getAbs_n()>this.abs_n){
			return -1;
		}else if(o.getAbs_n()<this.abs_n){
			return 1;
		}else{
			if(o.getN()>this.n){
				return -1;
			}else{
				return 1;
			}
		}
	}

}

public class bj_11286 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		PriorityQueue<number_11286> queue=new PriorityQueue<number_11286>();
		
		for (int i = 0; i < num; i++) {
			int n=Integer.parseInt(br.readLine());
			if(n==0){
				if(queue.isEmpty()){
					System.out.println(0);
				}else{
					System.out.println(queue.poll().getN());
				}
			}else{
				queue.add(new number_11286(n));
			}
		}

	}
}
