import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][]chess = new int[n][n];
			boolean[][]visited = new boolean[n][n];
			//델타(
			int[]dr = {-1,-2,-2,-1,1,2,2,1};
			int[]dc = {-2,-1,1,2,2,1,-1,-2};
			
			Queue<int[]>q = new LinkedList<>();
			
			
			
			int[][]sted = new int[2][2];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				sted[i][0] = Integer.parseInt(st.nextToken());
				sted[i][1] = Integer.parseInt(st.nextToken());
			}
			if(sted[0][0]==sted[1][0] && sted[0][1] == sted[1][1]) {
				System.out.println(0);
				continue;
			}else {
				q.add(new int [] {sted[0][0], sted[0][1],0});
				visited[sted[0][0]][sted[0][1]] = true;
			}
			
			int ans = Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				int[]tmp = q.poll();
				for(int i=0; i<8; i++) {
					int nr = tmp[0]+dr[i];
					int nc = tmp[1]+dc[i];
					if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]) {
						if(nr == sted[1][0] && nc == sted[1][1]) {
							ans = Math.min(ans, tmp[2]+1);
						}
						int[]nt = {nr, nc, tmp[2]+1};
						q.add(nt);
						visited[nr][nc] = true;
					}
				}
			}
			System.out.println(ans);
		}
	}
}