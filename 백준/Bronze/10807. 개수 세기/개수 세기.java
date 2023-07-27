import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int n = sc.nextInt();
		int t = 0;
		int [] nums = new int[n];
		for(int i = 0; i <n; i++) {
			nums[i] = sc.nextInt();
		}
		int s = sc.nextInt();
		for(int i = 0; i <n; i++) {
			if(nums[i]==s) {
				t +=1;
			}
		}
		System.out.println(t);
	}
}