import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][][] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dh = { 0, 0, 0, 0, -1, 1 }; // 상자 높이는 위아래로만 이동
		int[] dr = { -1, 0, 1, 0, 0, 0 };
		int[] dc = { 0, 1, 0, -1, 0, 0 };
		String str = br.readLine();

		while (!str.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(str);
			int h = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(h==0) {
				return;
			}
			
			int eh = 0;
			int er = 0;
			int ec = 0;

			char[][][] building = new char[h][r][c]; // 토마토 담을 3차원 배열 만들기
			Queue<int[]> q = new LinkedList<>(); // BFS에 사용할 큐 만들기
			int[][][] visited = new int[h][r][c]; // 상자 방문배열
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < r; j++) {
					Arrays.fill(visited[i][j], -1);
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < r; j++) {
					String str1 = br.readLine();
					for (int k = 0; k < c; k++) {
						building[i][j][k] = str1.charAt(k); // 상자에 토마토 넣기
						if (building[i][j][k] == 'S') {
							q.add(new int[] { i, j, k}); // 높이, 세로, 가로, 날짜
							visited[i][j][k] = 0; // 방문처리
						}
						if (building[i][j][k] == 'E') {
							eh = i;
							er = j;
							ec = k;
						}
					}
				}
				br.readLine();
			}

			int ans = 0;

			while (!q.isEmpty()) {
				int[] t = q.poll();

				for (int i = 0; i < 6; i++) {
					int nh = t[0] + dh[i];
					int nr = t[1] + dr[i];
					int nc = t[2] + dc[i];
					// 새로운 위치가 인덱스를 벗어나지 않고 방문하지 않았으며 토마토가 아직 안익었다면
					if (nr >= 0 && nr < r && nc >= 0 && nc < c && nh >= 0 && nh < h && visited[nh][nr][nc] == -1
							&& building[nh][nr][nc] != '#') {
						if (nh == eh && nr == er && nc == ec) {
							ans = visited[t[0]][t[1]][t[2]] + 1;
							break;
						}
						q.add(new int[] { nh, nr, nc });
						visited[nh][nr][nc] = visited[t[0]][t[1]][t[2]] + 1;
					}
				}
			}
			if(ans ==0) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in "+ans+" minute(s).");
			}
			str = br.readLine();
		}
	}
}