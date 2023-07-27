import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[]Student = new int[30];
		int temp = 0;
		
		for (int i = 0; i<28; i++) {
			int n = sc.nextInt();
			for(int j =0; j<30; j++) {
				if(j == n-1) {
					Student[j]=1;
					break;
				}
			}
		}
		for(int i = 0; i<30; i++) {
			if(Student[i] != 1)
				System.out.println(i+1);
		}
	}
}