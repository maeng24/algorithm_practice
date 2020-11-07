package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_2841 {
	class line implements Comparable<line> {
		private int linenum;
		private int pret;

		public line(int linenum, int pret) {
			this.linenum = linenum;
			this.pret = pret;
		}

		public int getLinenum() {
			return linenum;
		}

		public void setLinenum(int linenum) {
			this.linenum = linenum;
		}

		public int getPret() {
			return pret;
		}

		public void setPret(int pret) {
			this.pret = pret;
		}

		@Override
		public int compareTo(line o) {
			// TODO Auto-generated method stub
			return this.pret - o.pret;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		int N=Integer.parseInt(tk.nextToken());
		int P=Integer.parseInt(tk.nextToken());
		
		Stack<Integer>[] line=new Stack[6];

		for(int i=0;i<6;i++){
			line[i]=new Stack<>();
		}

		int answer=0;
		for(int i=0;i<N;i++){
			tk=new StringTokenizer(br.readLine()," ");
			
			int l=Integer.parseInt(tk.nextToken())-1;
			int pret=Integer.parseInt(tk.nextToken());
			//잡은 현의 프렛보다 작으면 누른다.
			if(line[l].isEmpty()||line[l].peek()<pret){
				answer++;
				line[l].add(pret);
			}else if(line[l].peek()>pret){
				//누른 현이 작거나 같은 수 가 될 때까지 혹은 모든 손을 뗄 때까지
				while(true){
					line[l].pop();
					answer++;
					if(line[l].isEmpty()||line[l].peek()<pret){
						answer++;
						line[l].add(pret);
						break;
					}else if(line[l].peek()==pret){
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
