import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main{
	static int n, m,cnt,result;
	static char[][] board;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static List<Character>visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		result = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}
		}
	
				cnt =0;
				visited = new ArrayList<>();
				dfs(0,0);
				
			
		System.out.println(result); //자기자신은 빼주기
	}

	public static void dfs(int br, int bc) {
		visited.add(board[br][bc]);
//		System.out.println(br+" "+bc);
		cnt++;
		
		loop1 :for(int i=0; i<4; i++) {
			int nr = br+dr[i];
			int nc = bc+dc[i];
			if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
				for(char al : visited) {
					if(al==board[nr][nc]) {
						continue loop1;
					}
				}
				dfs(nr,nc);
			}
		}
		visited.remove(visited.size()-1);
		result = Math.max(result, cnt);
		cnt--;
	}
}
