import java.util.Scanner;

public class Solution {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  //테스트 케이스 수 입력
        //테스트 케이스 만큼 반복
        for (int t = 1; t <= T; t++) {
        	int n = sc.nextInt();
        	int [][]arr = new int[n][n];
        	
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			arr[i][j] = sc.nextInt();
        		}
        	}
        	System.out.println("#"+t);
        	for (int i = 0; i <n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[n-1-j][i]);
				}System.out.print(" ");
				for (int j = 0; j < n; j++) {
					System.out.print(arr[n-1-i][n-1-j]);
				}System.out.print(" ");
				for (int j = 0; j < n; j++) {
					System.out.print(arr[j][n-1-i]);
				}
				System.out.println();
			}
		}
    }
}