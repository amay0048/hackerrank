package data_structures.solution_08_heaps;


import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anthonymay on 27/12/16.
 */
public class MainTest {

    @Test
    public void Case000() throws Exception {
        BufferedReader rdr = getTestFile("case000", Direction.INPUT);

        String solution = Main.Solution(rdr);
        String out = getCaseOutput("case000");

        System.out.println(solution);
        System.out.println(out);

        Assert.assertTrue(solution.equals(out));
    }

    private String solution = "solution_08_heaps";

    private BufferedReader getTestFile(String caseName, Direction direction) throws Exception {
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/src/data_structures/" + this.solution + "/test/" + caseName + "/" + direction + ".txt");

        File testInput = new File(filePath);
        Reader input = new FileReader(testInput);
        return new BufferedReader(input);
    }

    private String getCaseOutput(String caseName) throws Exception {
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/src/data_structures/" + this.solution + "/test/" + caseName + "/" + Direction.OUTPUT + ".txt");

        List<String> stringList = Files.readAllLines(Paths.get(filePath));
        return stringList.stream().collect(Collectors.joining("\n"));
    }

    public enum Direction {
        INPUT {
            public String toString() {
                return "in";
            }
        },

        OUTPUT {
            public String toString() {
                return "out";
            }
        }
    }
}