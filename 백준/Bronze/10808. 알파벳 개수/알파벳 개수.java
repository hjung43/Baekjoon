import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] al = new int[26];
        for(int i=0; i<S.length(); i++){
            al[S.charAt(i)-'a']++;
        }
        for(int i=0; i<al.length; i++){
            System.out.print(al[i]+" ");
        }
    }
}
