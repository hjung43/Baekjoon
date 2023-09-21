import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, cnt, result;
	static int k;
	static List<Integer>[]arr;
	static Queue<Integer>queue;
	static boolean[]visited;
	static int[]p;
	static List<Integer>list;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new ArrayList[101];
			queue = new LinkedList<>();
			visited = new boolean[101];
			p = new int[101];
			
			for(int i=0; i<101; i++) {
				arr[i] = new ArrayList<>();
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0; i<n/2; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				arr[a].add(b);
			}
			cnt = 0;
			result = 0;
			bfs(k);
			list = new ArrayList<>();
			for(int i=0; i<101; i++) {
				if(cnt == p[i]) {
					list.add(i);
				}
			}
			Collections.sort(list);
			System.out.println("#"+t+" "+list.get(list.size()-1));
		}
	}
	public static void bfs(int v) {
		queue.add(k);
		visited[k] = true;
		
		while(!queue.isEmpty()) {
			int t = queue.poll();
			for(int i=0; i<arr[t].size(); i++) {
				int nv = arr[t].get(i);
				if(!visited[nv]) {
					queue.add(nv);
					visited[nv] = true;
					p[nv]=p[t]+1;
					
					if(cnt<=p[nv]) {
						cnt = p[nv];
					}
							
				}
			}
		}
		
		
		
		
		
		
		
	}
}
