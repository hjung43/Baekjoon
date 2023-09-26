import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken()); //전체 건물 층수
		int s = Integer.parseInt(st.nextToken()); //강호가 있는 층
		int g = Integer.parseInt(st.nextToken()); //스타트링크가 있는 층
		int u = Integer.parseInt(st.nextToken()); //한번에 올라갈 수 있는 층수
		int d = Integer.parseInt(st.nextToken()); //한번에 내려올 수 있는 층수
		
		if(s==g) {
			System.out.println(0);
			return;
		}
		
		int[]ds = {u,-d};
		
		Queue<Integer>q = new LinkedList<>();
		int[]visited = new int[f+1];
		Arrays.fill(visited, -1);
		
		q.add(s);
		visited[s] = 0;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			for(int i=0; i<2; i++) {
				int nt = t+ds[i];
				if(nt>0 && nt<=f && visited[nt]==-1) {
					if(nt == g) {
						System.out.println(visited[t]+1);
						return;
					}
					q.add(nt);
					visited[nt] = visited[t]+1;
				}
			}
		}
		System.out.println("use the stairs");
	}
}