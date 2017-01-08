package basic_stats.solution_02_weighted_mean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main {

    public static String Solution(BufferedReader rdr) throws Exception {
        String newLine = System.getProperty("line.separator");
        Scanner scanner = new Scanner(rdr);

        StringJoiner out = new StringJoiner(newLine);

        int numerator = 0, denominator = 0;

        int cases = scanner.nextInt();
        int[] set = new int[cases];
        int[] weights = new int[cases];

        for (int i = 0; i<cases; i++) {
            set[i] = scanner.nextInt();
        }

        for (int i = 0; i<cases; i++) {
            weights[i] = scanner.nextInt();
            numerator += set[i] * weights[i];
            denominator += weights[i];
        }

        float mean = (float) numerator / denominator;
        out.add(String.format("%.1f", mean));

        scanner.close();
        return out.toString();
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
