package data_structures.solution_08_heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

class MaxComparator implements Comparator<Integer>
{
    public int compare( Integer x, Integer y )
    {
        return y - x;
    }
}

public class Main {

    public static String Solution(BufferedReader rdr) throws Exception {

        String newLine = System.getProperty("line.separator");
        Scanner scanner = new Scanner(rdr);

        StringJoiner out = new StringJoiner(newLine);

        int n = scanner.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n/2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n/2, new MaxComparator());

        int[] a = new int[n];
        for(int i=0; i < n; i++){
            a[i] = scanner.nextInt();

            if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                minHeap.add(a[i]);
            } else if (a[i] < (int) minHeap.peek()) {
                maxHeap.add(a[i]);
            } else {
                minHeap.add(a[i]);
            }

            int heapDifference = Math.abs(minHeap.size() - maxHeap.size());

            if (heapDifference > 1){
                // Balance the heaps
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.remove());
                } else {
                    maxHeap.add(minHeap.remove());
                }
            }

            if (maxHeap.size() == minHeap.size()) {
                Integer min = (Integer) minHeap.peek();
                Integer max = (Integer) maxHeap.peek();
                Float median = (min.floatValue() + max.floatValue()) / 2;
                out.add(Float.toString(median));
            } else {
                // odd
                if (maxHeap.size() > minHeap.size()) {
                    Integer max = (Integer) maxHeap.peek();
                    out.add(Float.toString(max.floatValue()));
                } else {
                    Integer min = (Integer) minHeap.peek();
                    out.add(Float.toString(min.floatValue()));
                }
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
