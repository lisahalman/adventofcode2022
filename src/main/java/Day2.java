import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("src/main/Day2.txt").toPath());
        String opponent = "";
        String me = "";
        int totalScorePartOne = 0;
        int totalScorePartTwo = 0;
        for (String line : lines) {
            opponent = line.substring(0, 1);
            me = line.substring(2);
            int scorePartOne = doRockPaperScissorPartOne(opponent, me);
            int scorePartTwo = doRockPaperScissorPartTwo(opponent, me);
            totalScorePartOne += scorePartOne;
            totalScorePartTwo += scorePartTwo;

        }
        System.out.println(totalScorePartOne);
        System.out.println(totalScorePartTwo);
    }

    public static int doRockPaperScissorPartOne(String opponent, String me) {
        int thisScore = 0;
        switch(opponent) {
            case "A":
                switch (me) {
                    case "X" -> thisScore = 1 + 3;
                    case "Y" -> thisScore = 2 + 6;
                    case "Z" -> thisScore = 3 + 0;
                }
                break;
            case "B":
                thisScore = switch (me) {
                    case "X" -> 1 + 0;
                    case "Y" -> 2 + 3;
                    case "Z" -> 3 + 6;
                    default -> thisScore;
                };
                break;
            case "C":
                thisScore = switch (me) {
                    case "X" -> 1 + 6;
                    case "Y" -> 2 + 0;
                    case "Z" -> 3 + 3;
                    default -> thisScore;
                };
                break;
        }
        return thisScore;
    }

    public static int doRockPaperScissorPartTwo(String opponent, String me) {
        int thisScore = 0;
        switch(opponent) {
            case "A":
                switch (me) {
                    case "X" -> thisScore = 0 + 3;
                    case "Y" -> thisScore = 3 + 1;
                    case "Z" -> thisScore = 6 + 2;
                }
                break;
            case "B":
                thisScore = switch (me) {
                    case "X" -> 0 + 1;
                    case "Y" -> 3 + 2;
                    case "Z" -> 6 + 3;
                    default -> thisScore;
                };
                break;
            case "C":
                thisScore = switch (me) {
                    case "X" -> 0 + 2;
                    case "Y" -> 3 + 3;
                    case "Z" -> 6 + 1;
                    default -> thisScore;
                };
                break;
        }
        return thisScore;
    }
}