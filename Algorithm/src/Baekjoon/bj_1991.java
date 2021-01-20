package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1991 {

	static String preanswer="", inanswer="", postanswer="";
	static int[][] tree;
	static final int dot=46-65;

	public static void preorder(int n) { // 전위순회
		preanswer+=(char)(n+65);
		for (int i = 0; i < 2; i++) {
			if (tree[n][i] != dot) {
				preorder(tree[n][i]);
			}
		}
	}

	public static void inorder(int n) { // 중위순회
		if (tree[n][0] != dot) {
			inorder(tree[n][0]);
		}
		inanswer+=(char)(n+65);
		if (tree[n][1] != dot) {
			inorder(tree[n][1]);
		}
	}

	public static void postorder(int n) { // 후위순회 
		for (int i = 0; i < 2; i++) {
			if (tree[n][i] != dot) {
				postorder(tree[n][i]);
			}
		}

		postanswer+=(char)(n+65);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		StringTokenizer tk=null;

		tree = new int[27][2];

		for (int i = 0; i < num; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int n = (int)(tk.nextToken().charAt(0) - 65);
			tree[n][0] = (int)(tk.nextToken().charAt(0) - 65);
			tree[n][1] = (int)(tk.nextToken().charAt(0) - 65);
		}

		preorder(0);
		inorder(0);
		postorder(0);

		System.out.println(preanswer);
		System.out.println(inanswer);
		System.out.println(postanswer);
	}

}
