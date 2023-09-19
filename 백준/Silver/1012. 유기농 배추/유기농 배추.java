import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r,c,result;
	static int[][]farm;
	static boolean[][]visited;
	//델타 (상,우,하,좌)
	static int[]dr = {-1,0,1,0};
	static int[]dc = {0,1,0,-1};
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st1.nextToken());
			c = Integer.parseInt(st1.nextToken());
			int n = Integer.parseInt(st1.nextToken());
			farm = new int[r][c];
			visited = new boolean[r][c];
			for(int i=0; i<n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int cabR = Integer.parseInt(st2.nextToken());
				int cabC = Integer.parseInt(st2.nextToken());
				farm[cabR][cabC] = 1;
			}
			result = 0;
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(farm[i][j]==1 && !visited[i][j]) {
						result++;
						dfs(i,j);
					}
				}
			}
			System.out.println(result);
		}
    }
    
    public static void dfs (int cabR, int cabC) {
    	visited[cabR][cabC] = true;
    	for(int i=0; i<4; i++) {
    		int nr = cabR+dr[i];
    		int nc = cabC+dc[i];
    		
    		if(nr>=0 && nr<r && nc>=0 && nc<c && farm[nr][nc]==1 && !visited[nr][nc]) {
    			dfs(nr,nc);
    		}
    		
    	}
    }
	
}