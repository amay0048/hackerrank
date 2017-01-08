package data_structures.solution_01_arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static String Solution(BufferedReader rdr) throws Exception {
        String ln = rdr.readLine();

        String[] chars = ln.split(" ");

//        int chk = Integer.parseInt(chars[0]);
        int rotations = Integer.parseInt(chars[1]);

        ln = rdr.readLine();
        chars = ln.split(" ");

        if (rotations >= chars.length) {
            rotations = rotations % chars.length;
        }

        String[] out = new String[chars.length];
        System.arraycopy(chars, rotations, out, 0, chars.length-rotations);
        System.arraycopy(chars, 0, out, chars.length-rotations, rotations);

        return String.join(" ", out);
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
