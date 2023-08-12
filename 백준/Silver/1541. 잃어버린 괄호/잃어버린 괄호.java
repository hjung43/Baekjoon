import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String[] n = str.split("-");
		int[]nums=new int[n.length];
		int result = 0;
		for(int i=0; i<n.length; i++) {
			if(n[i].contains("+")) {
				String[]add = n[i].split("[+]");
				int sum = 0;
				for(int j=0; j<add.length; j++) {
					sum += Integer.parseInt(add[j]);
					nums[i]=sum;
				}
			}else {
				nums[i]=Integer.parseInt(n[i]);
			}
		
		}
		for(int i=1; i<nums.length; i++) {
			result += nums[i];
		}
		
		System.out.println(nums[0]-result);
	}
}