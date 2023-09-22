import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //정점수
		int m = Integer.parseInt(st.nextToken()); //간선수
		int r = Integer.parseInt(st.nextToken()); //시작정점
		
		List<Integer>[]list = new ArrayList[n+1];
		
		for(int i=0; i<n+1; i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=1; i<n+1; i++) {
			Collections.sort(list[i]);
		}
		int[]visited = new int[n+1];
		Queue<Integer>q = new LinkedList<>();
		
		int cnt = 1;
		
		q.add(r);
		visited[r] = cnt++;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			for(int i : list[t] ) {
				if(visited[i]==0) {
					q.add(i);
					visited[i]=cnt++;
				}
			}
		}
		for(int i = 1; i<n+1; i++) {
			System.out.println(visited[i]);
		}
	}
}