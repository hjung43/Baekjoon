import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> nums = new ArrayList<>();
		
		
		for(int i=0; i<9; i++) {
			nums.add(sc.nextInt());
		}
		loop:for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				List<Integer> list = new ArrayList<>();
				for(int k=0; k<nums.size(); k++) {
					list.add(nums.get(k));
				}
				list.remove(j);
				list.remove(i);
				int sum = 0;
				for(int k=0; k<list.size(); k++) {
					sum += list.get(k);
				}
				if(sum==100) {
					Collections.sort(list);
					for(int k=0; k<list.size(); k++) {
						System.out.println(list.get(k));
					}
					break loop;
				}
			}
		}
	}
}