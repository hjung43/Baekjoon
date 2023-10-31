import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m, size, ans, zcnt;
	static int[][] map;
	static Queue<int[]> q;
	static int[][] result;
	static List<int[]> list;
	static int[] sel;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		result = new int[n][n];
		list = new ArrayList<>();
		

		zcnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					list.add(new int[] { i, j, 0 });
					zcnt++;
				}
				if(map[i][j]==0) {
					zcnt++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			result[i] = map[i].clone();
		}
		size = list.size();
		sel = new int[m];
		ans = 0;
		comb(0, 0);
		System.out.println(ans);

	}

	static void comb(int idx, int sidx) {
		if (sidx == m) {
			bfs(zcnt-m);
			return;
		}
		if (idx == size) {
			return;
		}
		sel[sidx] = idx;
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}

	static void bfs(int zcnt) {
		int cnt = zcnt;
		q = new LinkedList<>();
		visited = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int[] tmp = list.get(sel[i]).clone();
			q.add(tmp);
			visited[tmp[0]][tmp[1]] = true;
		}

		int time = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = t[0] + dr[i];
				int nc = t[1] + dc[i];
				int nt = t[2] + 1;
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && result[nr][nc] != 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					time = nt;
					q.add(new int[] { nr, nc, nt });
					cnt--;
				}
			}
		}
		if(cnt==0) {
			if(ans<=0) {
				ans = time;
			}else if(ans>0) {
				ans = Math.min(time, ans);
			}
		}else {
			if(ans==0) {
				ans = -1;
			}
		}
	}
}