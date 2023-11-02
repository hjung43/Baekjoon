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
	static int n, m, di, dj, si, sj, time, result;
	static char[][] map;
	static Queue<int[]> wq;
	static Queue<int[]> sq;
	static int[][] wvisited;
	static boolean[][] svisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		loop: for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			wq = new LinkedList<>();
			sq = new LinkedList<>();
			wvisited = new int[n][m];
			svisited = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				Arrays.fill(wvisited[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*') {
						wq.add(new int[] { i, j, 0 });
						wvisited[i][j] = 0;
					} else if (map[i][j] == '@') {
						si = i;
						sj = j;
						sq = new LinkedList<>();
						sq.add(new int[] { si, sj, 0 });
						svisited[si][sj] = true;
					} else if (map[i][j] == '#') {
						wvisited[i][j] = -1;
					}

				}
			}

			while (!wq.isEmpty()) {
				int[] tmp = wq.poll();
//			System.out.println(tmp[0]+" "+tmp[1]+" "+tmp[2]);
				for (int i = 0; i < 4; i++) {
					int nr = tmp[0] + dr[i];
					int nc = tmp[1] + dc[i];
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != '#'
							&& wvisited[nr][nc] == Integer.MAX_VALUE) {
						int nt = tmp[2] + 1;
						wq.add(new int[] { nr, nc, nt });
						wvisited[nr][nc] = nt;
					}
				}
			}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(wvisited[i][j]);
//			}System.out.println();
//		}

			while (!sq.isEmpty()) {
				int[] tmp = sq.poll();
//			System.out.println(tmp[0]+" "+tmp[1]+" "+tmp[2]);
				for (int i = 0; i < 4; i++) {
					int nr = tmp[0] + dr[i];
					int nc = tmp[1] + dc[i];
					int nt = tmp[2] + 1;
					if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
//					System.out.println(tmp[0]+" "+tmp[1]);
						System.out.println(nt);
						continue loop;
					}
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == '.' && wvisited[nr][nc] > nt
							&& !svisited[nr][nc]) {
//					System.out.println(nr+" "+nc+" "+nt);
						sq.add(new int[] { nr, nc, tmp[2] + 1 });
						svisited[nr][nc] = true;
					}
				}
			}
			System.out.println("IMPOSSIBLE");
		}
	}
}