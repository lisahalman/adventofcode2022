import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day6 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day6.txt").toPath());
        String line = lines.get(0);
        System.out.println(lines);
        int index = 0;
        //part 1
        ArrayDeque<Character> listOfFour = new ArrayDeque<>();
        for (char letter : line.toCharArray()) {
            if (listOfFour.contains(letter)) {
                index++;
                for (char oneOfFour : listOfFour) {
                    char l = listOfFour.pop();
                    if (l == letter) {
                        break;
                    }
                }
                listOfFour.add(letter);
                continue;
            }
            listOfFour.add(letter);
            index++;
            if (listOfFour.size() == 14) {
                System.out.println(index);
                break;
            }
        }
    }
}