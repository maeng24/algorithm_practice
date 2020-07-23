package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		//num이 0 ,1 ,2 일 경우를 생각해서 배열을 잡는다
		int[] dp=new int[num+4];
		
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;
		
		//dp로 구하기
		for(int i=4;i<=num;i++){
			dp[i]=i;
			if(i%3==0){
				dp[i]=Math.min(dp[i], dp[i/3]+1);	
			}
			if(i%2==0){
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
			dp[i]=Math.min(dp[i], dp[i-1]+1);
		}
		System.out.println(dp[num]);
		
		// bfs, 메모리 초과
		/*
		 * int answer = 0;
		 * Queue<Integer> queue = new LinkedList<Integer>(); queue.add(num);
		 * boolean flag=true;
		 * 
		 * while (!queue.isEmpty()) { int n = queue.size(); answer++;
		 * 
		 * for (int i = 0; i < n; i++) {
		 * 
		 * int ans = queue.poll(); System.out.print(ans +" "); if (ans % 3 == 0)
		 * { if (ans / 3 == 1) { flag=false; break; } queue.add(ans / 3); } if
		 * (ans % 2 == 0) { if (ans / 2 == 1) { flag=false; break; }
		 * queue.add(ans / 2); } if (ans - 1 == 1) { flag=false; break; }
		 * queue.add(ans - 1);
		 * 
		 * } if(!flag){ break; } System.out.println(); }
		 * System.out.println(answer);
		 */

	}

}
