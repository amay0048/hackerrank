package basic_stats.solution_04_quartile_range;

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

    private static float median(int[] array) {
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

        int cases = scanner.nextInt(), setLen=0, runningLen=0;
        int[] elements = new int[cases];
        int[] frequency = new int[cases];

        for (int i = 0; i<cases; i++) {
            elements[i] = scanner.nextInt();
        }

        for (int i = 0; i<cases; i++) {
            frequency[i] = scanner.nextInt();
            setLen += frequency[i];
        }

        int[] set = new int[setLen];
        for (int i = 0; i<cases; i++) {
            Arrays.fill(set, runningLen, runningLen+frequency[i], elements[i]);
            runningLen += frequency[i];
        }
        Arrays.sort(set);

        float median = median(set);
        if(!isEven(set.length)) {
            set = remove(set, set.length/2);
        }

        float q1 = median(Arrays.copyOfRange(set, 0, set.length/2));
        float q3 = median(Arrays.copyOfRange(set, set.length/2, set.length));

        out.add(Float.toString(q3-q1));

        scanner.close();
        return out.toString();
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
