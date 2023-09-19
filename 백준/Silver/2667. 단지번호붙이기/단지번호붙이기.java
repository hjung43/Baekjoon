import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt, size;
	static int[][] apt;
	static boolean[][] visited;
	static int[]dr = {-1,0,1,0};
	static int[]dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		apt = new int[n][n];
		visited = new boolean[n][n];
		cnt = 0;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				apt[i][j] = str.charAt(j)-'0';
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(apt[i][j]==1 && !visited[i][j]) {
					cnt++;
					size = 1;
					dfs(i,j);
					pq.offer(size);
					
				}
			}
		}
		System.out.println(cnt);
		for(int i=0; i<cnt; i++) {
			System.out.println(pq.poll());
		}
		
	}
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<n && nc>=0 && nc<n && apt[nr][nc]==1 && !visited[nr][nc]) {
				size++;
				dfs(nr,nc);
			}
		}
	}

}