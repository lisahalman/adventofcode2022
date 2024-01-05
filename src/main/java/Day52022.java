import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day52022 {

    static List<String> pile1 = new ArrayList<String>(Arrays.asList("B", "G", "S", "C"));
    static List<String> pile2 = new ArrayList<String>(Arrays.asList("T", "M", "W", "H", "J", "N", "V", "G"));
    static List<String> pile3 = new ArrayList<String>(Arrays.asList("M", "Q", "S"));
    static List<String> pile4 = new ArrayList<String>(Arrays.asList("B", "S", "L", "T", "W", "N", "M"));
    static List<String> pile5 = new ArrayList<String>(Arrays.asList("J", "Z", "F", "T", "V", "G", "W", "P"));
    static List<String> pile6 = new ArrayList<String>(Arrays.asList("C", "T", "B", "G", "Q", "H", "S"));
    static List<String> pile7 = new ArrayList<String>(Arrays.asList("T", "J", "P", "B", "W"));
    static List<String> pile8 = new ArrayList<String>(Arrays.asList("G", "D", "C", "Z", "F", "T", "Q", "M"));
    static List<String> pile9 = new ArrayList<String>(Arrays.asList("N", "S", "H", "B", "P", "F"));

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("src/main/Day52022.txt").toPath());

        for (int i = 1; i < 11; i++) {
            lines.remove(0);
        }

        for (String line : lines) {
            String withoutMove = line.substring(5);
            String fromToTo = withoutMove.replace(" from ", " to ");
            String[] onlyNumbers = fromToTo.split(" to ");
            List<Integer> intArrayList = new ArrayList<>();
            for (String num : onlyNumbers) {
                intArrayList.add(Integer.parseInt(num));
            }
            System.out.println(intArrayList);
            int amountOfCrates = intArrayList.get(0);
            for (int i = 0; i < amountOfCrates; i++) {
                String letter = deleteCrate(intArrayList.get(1));
                addCrate(intArrayList.get(2), letter);
            }
        }
        System.out.println(pile1.get(pile1.size() - 1) + pile2.get(pile2.size() - 1) +pile3.get(pile3.size() - 1) +pile4.get(pile4.size() - 1) +pile5.get(pile5.size() - 1) +pile6.get(pile6.size() - 1) +pile7.get(pile7.size() - 1) +pile8.get(pile8.size() - 1) +pile9.get(pile9.size() - 1));
    }

    public static String deleteCrate(int from) {
        String letter = switch (from) {
            case 1 -> pile1.remove(pile1.size() - 1);
            case 2 -> pile2.remove(pile2.size() - 1);
            case 3 -> pile3.remove(pile3.size() - 1);
            case 4 -> pile4.remove(pile4.size() - 1);
            case 5 -> pile5.remove(pile5.size() - 1);
            case 6 -> pile6.remove(pile6.size() - 1);
            case 7 -> pile7.remove(pile7.size() - 1);
            case 8 -> pile8.remove(pile8.size() - 1);
            case 9 -> pile9.remove(pile9.size() - 1);
            default -> "";
        };
        return letter;
    }

    public static void addCrate(int to, String letter) {
        switch (to) {
            case 1 -> pile1.add(letter);
            case 2 -> pile2.add(letter);
            case 3 -> pile3.add(letter);
            case 4 -> pile4.add(letter);
            case 5 -> pile5.add(letter);
            case 6 -> pile6.add(letter);
            case 7 -> pile7.add(letter);
            case 8 -> pile8.add(letter);
            case 9 -> pile9.add(letter);
        }
    }

}