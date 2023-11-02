import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] map; //치즈 담을 배열
	static boolean[][]visited;
	static Queue<int[]> q;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result=0;
		//bfs
		q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					result++;
					bfs(i,j);
				}
			}
		}
		System.out.println(result);
	}
	
	static void bfs(int r, int c) {
		q = new LinkedList<>();
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[]tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nr = tmp[0]+dr[i];
				int nc = tmp[1]+dc[i];
				if(nr==-1)nr=n-1;
				if(nc==-1)nc=m-1;
				if(nr==n)nr=0;
				if(nc==m)nc=0;
				if(map[nr][nc]==0 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					map[nr][nc]=1;
					q.add(new int[] {nr,nc});
				}
			}
		}
		
	}
}