package data_structures.solution_02_strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    private static char[] remove(char[] array, int index) throws Exception {
        char[] out = new char[array.length - 1];

        if (index == 0) {
            System.arraycopy(array, 1, out, 0, out.length);
            return out;
        }

        if (index > out.length) {
            System.arraycopy(array, 0, out, 0, out.length);
            return out;
        }

        System.arraycopy(array, 0, out, 0, index);
        if (index + 1 <= out.length) {
            System.arraycopy(array, index+1, out, index, out.length-index);
        }

        return out;
    }

    public static String Solution(BufferedReader rdr) throws Exception {
        char[] a = rdr.readLine().toCharArray();
        char[] b = rdr.readLine().toCharArray();

        int total = a.length+b.length;
        int matches = 0;

        while (a.length > 0) {
            char query = a[0];
            a = remove(a, 0);
            for (int i=0;i<b.length;i++) {
                if(query == b[i]) {
                    b = remove(b,i);
                    matches++;
                    break;
                }
            }
        }

        total -= (matches*2);
        return String.valueOf(total);
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
