package basic_stats.solution_01_mean_median_mode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main {

    private static boolean isEven(int cases) {
        if (cases % 2 == 0) {
            return true;
        }
        return false;
    }

    public static String Solution(BufferedReader rdr) throws Exception {
        String newLine = System.getProperty("line.separator");
        Scanner scanner = new Scanner(rdr);

        StringJoiner out = new StringJoiner(newLine);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int cases = scanner.nextInt();
        int[] set = new int[cases];
        float mean=0, median=0;
        int mode=0, modeOccurrences = 0;

        for (int i = 0; i<cases; i++) {
            set[i] = scanner.nextInt();
            mean += set[i];
            map.compute(set[i], (Integer key, Integer val)->{
                if (val == null) val = 0;
                val++;
                return val;
            });
        }
        Arrays.sort(set);

        mean = mean / cases;
        out.add(Float.toString(mean));

        median = (float) set[cases/2];

        if (isEven(cases)) {
            median = ( median + (float) set[(cases/2)-1] ) / 2;
        }
        out.add(Float.toString(median));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > modeOccurrences) {
                modeOccurrences = entry.getValue();
                mode = entry.getKey();
            } else if (entry.getValue() == modeOccurrences && entry.getKey() < mode) {
                mode = entry.getKey();
            }
        }
        out.add(Integer.toString(mode));

        scanner.close();
        return out.toString();
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
