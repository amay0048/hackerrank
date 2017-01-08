package data_structures.solution_03_hashtables;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static String Solution(BufferedReader rdr) throws Exception {
        Scanner in = new Scanner(rdr);

        int a = in.nextInt();
        int b = in.nextInt();

        HashMap<String,Integer> magazine = new HashMap<String, Integer>();

        for (int i=0;i<a;i++) {
            String k = in.next();
            magazine.compute(k, (String key, Integer val)->{
                if (val == null) val = 0;
                val++;
                return val;
            });
        }

        String[] ransom = new String[b];
        for (int i=0;i<b;i++) {
            ransom[i] = in.next();
            if (magazine.containsKey(ransom[i])) {
                magazine.compute(ransom[i], (String key, Integer val)-> {
                    val--;
                    if (val <= 0) return null;
                    return val;
                });
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
