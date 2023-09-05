import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n ,m;
	static int[]arr;
	static int[]sel;
	static boolean[]visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		sb = new StringBuilder();
		arr = new int[n];
		sel = new int[m];
		visit = new boolean[n];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb);
	}
	//조합
	public static void comb(int idx, int sidx) {
		if(sidx == m) {
			for(int i=0; i<m; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		if(idx == n) {
			return;
		}
		sel[sidx]=arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
}