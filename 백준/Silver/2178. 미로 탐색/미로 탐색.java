import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][]map;
	//델타 상,우,하,좌
	static int[]dr = {-1,0,1,0};
	static int[]dc = {0,1,0,-1};
	static boolean[][]visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1});
		
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] tp = q.poll();
			for(int i=0; i<4; i++) {
				int nr = tp[0]+dr[i];
				int nc = tp[1]+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]==1 &&!visited[nr][nc]) {
					if(nr==n-1 && nc == m-1) {
						System.out.println(tp[2]+1);
						return;
					}
					int[]np = {nr, nc, tp[2]+1};
					q.add(np);
					visited[nr][nc] = true;
				}
			}
		}
	}
}