import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static boolean[] visited;
	static List<Integer>[] abjArr;
	static int n, m, cnt, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			result = 0;

			abjArr = new ArrayList[n + 1];
			visited = new boolean[n + 1];

			for (int i = 0; i < n + 1; i++) {
				abjArr[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				abjArr[x].add(y);
				abjArr[y].add(x);
			}
			for (int i = 1; i < n + 1; i++) {
				cnt = 1;
				dfs(i);
			}
			System.out.println("#" + t + " " + (result));

		}

	}

	public static void dfs(int nidx) {
		visited[nidx] = true;
		result = Math.max(cnt, result);

		for (int node : abjArr[nidx]) {
			if (!visited[node]) {
				cnt++;
				dfs(node);
				cnt--;
			}

		}
		visited[nidx] = false;
	}

}