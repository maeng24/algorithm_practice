package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int length=Integer.parseInt(br.readLine());
		int[] towerheight=new int[length];
		Stack<int[]> towers=new Stack<>();
		
		int[] answer=new int[length];
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<length;i++){
			towerheight[i]=Integer.parseInt(tk.nextToken());
		}
		
		// 탑의 높이 보다 작은 숫자들은 스택에서 꺼내며 정답에 마주친 탑을 저장한다.
		for(int i=length-1;i>=0;i--){
			while(!towers.isEmpty()&&towerheight[i]>=towers.peek()[1]){
				answer[towers.peek()[0]]=i+1;
				towers.pop();
			}
			towers.push(new int[]{i,towerheight[i]});
		}
		
		for(int i=0;i<length;i++){
			System.out.print(answer[i]+" ");
		}
	}

}
