import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alp = new int[26];
        Arrays.fill(alp, -1);
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            int spell = s.charAt(i)-'a';
            if(alp[spell]==-1){
                alp[spell]=idx;
            }
            idx++;
        }

        for(int i=0; i<alp.length; i++){
                System.out.print(alp[i]+" ");
        }


    }
}