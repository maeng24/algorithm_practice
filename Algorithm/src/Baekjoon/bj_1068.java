package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1068 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		int[] tree=new int[num];
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<num;i++){
			tree[i]=Integer.parseInt(tk.nextToken());
		}
		
		int index=Integer.parseInt(br.readLine());
		Queue<Integer> cutindex=new LinkedList<Integer>();
		
		//잘라야할 노드를 기준으로 하위 노드들을 잘라낸다.
		cutindex.add(index);
		while(!cutindex.isEmpty()){
			index=cutindex.poll();
			tree[index]=-100;
			for(int i=0;i<num;i++){
				if(tree[i]==index){
					cutindex.add(i);
				}
			}
		}
		
		int answer=0;
		boolean flag=true;//하위 노드가 있는지 판별
		for(int i=0;i<num;i++){
			if(tree[i]!=-100){
				flag=true;
				for(int j=0;j<num;j++){
					if(i==tree[j]){
						flag=false;
						break;
					}
				}
				if(flag){
					answer++;
				}
			}
		}
		
		System.out.println(answer);

	}

}
