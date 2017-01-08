package basic_stats.solution_03_quartiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main {

    private static boolean isEven(int i) {
        if (i % 2 == 0) return true;
        return false;
    }

    private static int[] remove(int[] array, int index) {
        int[] out = new int[array.length-1];

        System.arraycopy(array, 0, out, 0, index);
        System.arraycopy(array, index+1, out, index, out.length-index);

        return out;
    }

    private static int median(int[] array) {
        int i = array.length/2;
        if (!isEven(array.length)) {
            return array[i];
        }
        return (array[i] + array[i-1]) / 2;
    }

    public static String Solution(BufferedReader rdr) throws Exception {
        String newLine = System.getProperty("line.separator");
        Scanner scanner = new Scanner(rdr);

        StringJoiner out = new StringJoiner(newLine);

        int cases = scanner.nextInt(), median;
        int[] set = new int[cases];

        for (int i = 0; i<cases; i++) {
            set[i] = scanner.nextInt();
        }
        Arrays.sort(set);

        median = median(set);
        if(!isEven(cases)) {
            set = remove(set, cases/2);
            cases = set.length;
        }

        int q1 = median(Arrays.copyOfRange(set, 0, cases/2));
        int q3 = median(Arrays.copyOfRange(set, cases/2, cases));

        out.add(Integer.toString(q1));
        out.add(Integer.toString(median));
        out.add(Integer.toString(q3));

        scanner.close();
        return out.toString();
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
