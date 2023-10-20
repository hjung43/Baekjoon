

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
		int n = Integer.parseInt(st.nextToken()); // 사다리수
		int m = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		int[]list = new int[101];
		
		Arrays.fill(list, -1);
		
		for(int i=0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a]=b;
		}
		
		int result = 0;
		
		Queue<int[]>q = new LinkedList<>();
		q.add(new int[] {1,0});
		
		loop1 :while(!q.isEmpty()) {
			int[]tmp = q.poll();
			int max = 0;
			for(int i=1; i<=6; i++) {
				int nv = tmp[0]+i;
				int nd = tmp[1]+1;
				if(nv>=100) {
					result = nd;
					break loop1;
				}
				if(list[nv]!=-1) {
					q.add(new int[] {list[nv], nd});
				}else {
					max = Math.max(max, i);
				}
			}
			if(max!=0) {
				q.add(new int[] {tmp[0]+max,tmp[1]+1});
			}
		}
		
		System.out.println(result);

	}
}