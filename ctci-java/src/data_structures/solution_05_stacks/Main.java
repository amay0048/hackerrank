package data_structures.solution_05_stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

public class Main {

    private static char[] shrink(char[] arr) {
        char[] out = new char[arr.length-1];
        System.arraycopy(arr, 1, out, 0, out.length);
        return out;
    }

    private static boolean check(Stack<Character> stack, char c) {
        if (stack.isEmpty()) return false;
        return false;
    }

    private static String isBalanced(String input) {
        char[] chars = input.toCharArray();
        Stack<Character> characterStack = new Stack<Character>();

        while (chars.length > 0) {
            char c = chars[0];
            chars = shrink(chars);
            char check;

            switch (c) {
                case '(':
                case '{':
                case '[':
                    characterStack.push(c);
                    break;
                case ')':
                    check = '(';
                    if (characterStack.isEmpty() || characterStack.pop() != check) {
                        return "NO";
                    }
                    break;
                case '}':
                    check = '{';
                    if (characterStack.isEmpty() || characterStack.pop() != check) {
                        return "NO";
                    }
                    break;
                case ']':
                    check = '[';
                    if (characterStack.isEmpty() || characterStack.pop() != check) {
                        return "NO";
                    }
                    break;

            }
        }

        if (!characterStack.isEmpty()) return "NO";
        return "YES";
    }

    public static String Solution(BufferedReader rdr) throws Exception {

        String line = rdr.readLine().trim();
        int cases = Integer.parseInt(line);

        String[] out = new String[cases];

        for (int i=0; i<cases; i++) {
            out[i] = isBalanced(rdr.readLine().trim());
        }

        return String.join("\n", out);
    }

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(System.in);
        BufferedReader rdr = new BufferedReader(input);
        System.out.println(Solution(rdr));
    }
}
