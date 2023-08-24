import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][]arr = new int[102][102];
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt()+1;
			int y = sc.nextInt()+1;
			for(int j=y; j<y+10; j++) {
				for(int k=x; k<x+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i < 102; i++) {
			for (int j = 1; j <102; j++) {
				if(arr[i][j]==1) {
					if(arr[i-1][j]==0) 
						cnt++;
					if(arr[i+1][j]==0) 
						cnt++;
					if(arr[i][j-1]==0) 
						cnt++;
					if(arr[i][j+1]==0) 
						cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}