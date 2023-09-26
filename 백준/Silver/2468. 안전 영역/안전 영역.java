import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,maxh;
	static int[][]map;
	static boolean[][]visited;
	static Queue<Point>q;
	static int[]dr = {-1,0,1,0};
	static int[]dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		maxh = 0;
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxh = Math.max(maxh, map[i][j]);
			}
		}
		for(int i=0; i<=maxh; i++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(!visited[j][k] && map[j][k]>i) {
						cnt++;
						q = new LinkedList<>();
						Point p = new Point(j ,k);
						q.add(p);
						BFS(i);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	public static void BFS(int h) {
		while(!q.isEmpty()) {
			Point tp = q.poll();
			for(int i=0; i<4; i++) {
				int nr = tp.x+dr[i];
				int nc = tp.y+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc] && map[nr][nc] > h) {
					Point np = new Point(nr, nc);
					q.add(np);
					visited[nr][nc] = true;
				}
			}
		}
	}
}