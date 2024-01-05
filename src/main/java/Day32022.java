import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day32022 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("src/main/Day32022.txt").toPath());
        ArrayList<Character> duplicateLetters = new ArrayList<>();
        for (String line : lines) {
            int length = line.length();
            int halfOfLength = length / 2;
            String firstHalf = line.substring(0, halfOfLength);
            String secondHalf = line.substring(halfOfLength);
            Map<Character, Integer> map = new HashMap<>();
            for (char c : firstHalf.toCharArray()) {
                map.put(c, 0);
            }
            for (char c : secondHalf.toCharArray()) {
                if (map.containsKey(c)) {
                    duplicateLetters.add(c);
                    break;
                }
            }
        }
        String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 0;
        for (char c : duplicateLetters) {
            int position = alphabet.indexOf(c);
            count += position;
        }
        System.out.println(count);
        System.out.println("---------------------");
        ArrayList<String> listofThreeElves = new ArrayList<>();
        ArrayList<Character> duplicateLettersPart2 = new ArrayList<>();
        for (String line : lines) {
            listofThreeElves.add(line);
            if (((lines.indexOf(line))+1) % 3 == 0) {
                char badge = computeBadge(listofThreeElves);
                duplicateLettersPart2.add(badge);
                listofThreeElves.clear();
            }
        }
        int count2 = 0;
        for (char c : duplicateLettersPart2) {
            int position = alphabet.indexOf(c);
            count2 += position;
        }
        System.out.println(count2);
    }

    public static char computeBadge(ArrayList<String> listofThreeElves) {
        char badge = '0';
        String elf1 = listofThreeElves.get(0);
        String elf2 = listofThreeElves.get(1);
        String elf3 = listofThreeElves.get(2);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : elf1.toCharArray()) {
            map.put(c, 0);
        }
        for (char c : elf2.toCharArray()) {
            if (map.containsKey(c)) {
                if (elf3.contains("" + c)) {
                    badge = c;
                }
            }
        }
        return badge;
    }
}