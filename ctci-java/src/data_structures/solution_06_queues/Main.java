package data_structures.solution_06_queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main {

    public static String Solution(BufferedReader rdr) throws Exception {

        String newLine = System.getProperty("line.separator");
        Scanner scanner = new Scanner(rdr);
        int cases = scanner.nextInt();

        Queue<Integer> integerQueue = new LinkedList<Integer>();
        StringJoiner out = new StringJoiner(newLine);

        for (int i=0; i<cases; i++) {
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    integerQueue.add(scanner.nextInt());
                    break;
                case 2:
                    integerQueue.remove();
                    break;
                case 3:
                    out.add(integerQueue.peek().toString());
                    break;
            }
        }

        scanner.close();
        return out.toString();
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
