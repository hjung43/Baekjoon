import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] p = new int[101][101];
		int n = sc.nextInt();
		int count =0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(p[j][k] == 0) {
						p[j][k] = 1;
						count++;
					}
				}
			}
		}System.out.println(count);
		
	}
}