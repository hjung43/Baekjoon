import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st1.nextToken());
			int e = Integer.parseInt(st1.nextToken());
			List<Integer>[] arr = new ArrayList[v + 1];
			int[] degree = new int[v + 1];
			for (int i = 0; i < v + 1; i++) {
				arr[i] = new ArrayList<>();
			}

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				arr[a].add(b);
				degree[b]++;
			}

			Queue<Integer> q = new LinkedList<>();

			for (int i = 1; i < v + 1; i++) {
				if (degree[i] == 0) {
					q.add(i);
				}
			}
			System.out.print("#"+t+" ");
			while (!q.isEmpty()) {
				int work = q.poll();
				System.out.print(work + " ");

				for (int n : arr[work]) {
					degree[n]--;

					if (degree[n] == 0) {
						q.add(n);
					}
				}

			}
			System.out.println();
		}
	}
}