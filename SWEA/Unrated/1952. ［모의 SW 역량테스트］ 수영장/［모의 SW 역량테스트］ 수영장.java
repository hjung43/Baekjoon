import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] price;
	static int[] use;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++) {
			int[]price = new int[4];
			int[]use = new int[13];
			int[]result = new int[13];
		
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				int day = Integer.parseInt(st.nextToken());
				if(day==0) {
					use[i]=0;
				}else if(day*price[0]<=price[1]) {
					use[i] = day*price[0];
				}else {
					use[i] = price[1];
				}
			}
			
			for(int i=1; i<=12; i++) {
				if(i>=3) {
					result[i] = Math.min(result[i-1]+use[i], result[i-3]+price[2]);
				}else {
					result[i] = result[i-1]+use[i];
				}
			}
			int ans = Math.min(result[12], price[3]);
			
			System.out.println("#"+t+" "+ans);
		}

	}
}