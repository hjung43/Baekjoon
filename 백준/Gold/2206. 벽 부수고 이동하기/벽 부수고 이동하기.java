
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] map;
	static boolean[][][] visited;
	static Queue<int[]> q;
	static int result;
	static boolean boom;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		q = new LinkedList<>();
		result = Integer.MAX_VALUE;
		boom = false;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		if(n ==1 && m==1) {
			System.out.println(1);
			return;
		}
		
		
		bfs(0,0,1,0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	static void bfs(int r, int c, int t, int b) {
		visited = new boolean[n][m][2];
		visited[r][c][0] = true;
		q.add(new int[] { r, c, t ,b});

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				int nt = tmp[2] + 1;
				if (nt > result) {
					break;
				}
				if (nr == n - 1 && nc == m - 1) {
					result = Math.min(result, tmp[2] + 1);
					break;
				}
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc]==0) {
					if(!visited[nr][nc][0] && tmp[3]==0) {
						visited[nr][nc][0] = true;
						q.add(new int[] { nr, nc, nt ,tmp[3]});
					}else if(!visited[nr][nc][1] && tmp[3]==1) {
						visited[nr][nc][1] = true;
						q.add(new int[] { nr, nc, nt ,tmp[3]});
					}
				}
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc][1] && map[nr][nc] == 1 && tmp[3]==0) {
					visited[nr][nc][1] = true;
					q.add(new int[] { nr, nc, nt ,1});
				}
			}
		}
	}

}