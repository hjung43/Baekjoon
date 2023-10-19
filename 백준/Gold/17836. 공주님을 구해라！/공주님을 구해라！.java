import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m, t;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<>();
		result = Integer.MAX_VALUE;
		int xr = 0;
		int xc = 0;
		int xd = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					xr = i;
					xc = j;
				}
			}
		}
		q.add(new int[] { 0, 0, 0 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				int nt = tmp[2] + 1;
				if (nr == n - 1 && nc == m - 1) {
					result = Math.min(result, nt);
					break;
				}
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] ==2) {
					xd = nt;
				}
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc]!=1) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, nt });

				}
			}

		}
		if(xd ==0 && result == Integer.MAX_VALUE) {
			System.out.println("Fail");
		}else {
			int xt = xd + (n-1-xr) + (m-1-xc);
			result = Math.min(xt, result);
			if (result > t) {
				System.out.println("Fail");
			} else {
				System.out.println(result);
			}
		}
		
		
		
		

	}

}