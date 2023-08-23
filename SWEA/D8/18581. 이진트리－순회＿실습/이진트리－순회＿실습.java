import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static int [][]arr; //글자 담을 배열 선언
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int [n+1][2];
        // 테스트 케이스 수 만큼 반복
        for (int i = 1; i <n; i++) {
        	int p = sc.nextInt();
        	int c = sc.nextInt();
        	if(arr[p][0]==0) {
        		arr[p][0] = c;
        	}else {
        		arr[p][1]=c;
        	}
        }
        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
        
    }
    public static void preOrder (int i) {
    	System.out.print(i+" ");
    	int l = arr[i][0];
    	int r = arr[i][1];
    	if(l!=0)
    		preOrder(l);
    	if(r!=0)
    		preOrder(r);
    }
    public static void inOrder (int i) {
    	int l = arr[i][0];
    	int r = arr[i][1];
    	if(l!=0)
    		inOrder(l);
    	System.out.print(i+" ");
    	if(r!=0)
    		inOrder(r);
    }
    public static void postOrder (int i) {
    	int l = arr[i][0];
    	int r = arr[i][1];
    	if(l!=0)
    		postOrder(l);
    	if(r!=0)
    		postOrder(r);
    	System.out.print(i+" ");
    }
}