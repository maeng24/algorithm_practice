package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_5427 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] movex = { 1, 0, -1, 0 };
		int[] movey = { 0, 1, 0, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			char[][] map = new char[y][x];
			Queue<int[]> fire = new LinkedList<int[]>();
			Queue<int[]> people = new LinkedList<int[]>();
			boolean flag = true;

			for (int j = 0; j < y; j++) {
				String str = br.readLine();
				for (int k = 0; k < x; k++) {
					map[j][k] = str.charAt(k);
					if (map[j][k] == '*') {
						fire.add(new int[] { j, k });
					} else if (map[j][k] == '@') {
						people.add(new int[] { j, k });
					}
				}
			}

			int count = 0;

			while (!people.isEmpty()) {
				count++;
				int firelen = fire.size();
				for (int j = 0; j < firelen; j++) {
					int firey = fire.peek()[0];
					int firex = fire.poll()[1];
					for (int k = 0; k < 4; k++) {
						int nextx = firex + movex[k];
						int nexty = firey + movey[k];
						if (nextx >= 0 && nextx < x && nexty >= 0 && nexty < y && map[nexty][nextx] != '*'
								&& map[nexty][nextx] != '#') {
							map[nexty][nextx] = '*';
							fire.add(new int[] { nexty, nextx });
						}
					}
				}

				int peoplelen = people.size();
				for (int j = 0; j < peoplelen; j++) {
					int peopley = people.peek()[0];
					int peoplex = people.poll()[1];
					for (int k = 0; k < 4; k++) {
						int nextx = peoplex + movex[k];
						int nexty = peopley + movey[k];
						if (nextx < 0 || nexty < 0 || nextx >= x || nexty >= y) {
							flag = false;
							break;
						} else if (nextx >= 0 && nextx < x && nexty >= 0 && nexty < y && map[nexty][nextx] != '*'
								&& map[nexty][nextx] != '#') {
							people.add(new int[] { nexty, nextx });
						}
					}
					if (!flag) {
						break;
					}
				}
				if (!flag) {
					break;
				}
			}
			if (!flag) {
				System.out.println(count);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}

}
