import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day42022 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("src/main/Day42022.txt").toPath());
        int count = 0;
        for (String line : lines) {
            String newLine = line.replace(",", "-");
            String[] stringArrayList = newLine.split("-");
            List<Integer> intArrayList = new ArrayList<>();
            for (String num : stringArrayList) {
                intArrayList.add(Integer.parseInt(num));
            }
            if (intArrayList.get(0) <= intArrayList.get(2) && intArrayList.get(1) >= intArrayList.get(3)) {
                count++;
                continue;
            }
            if (intArrayList.get(2) <= intArrayList.get(0) && intArrayList.get(3) >= intArrayList.get(1)) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println("----------------");
        //second part
        int count2 = 0;
        for (String line : lines) {
            String newLine = line.replace(",", "-");
            String[] stringArrayList = newLine.split("-");
            List<Integer> intArrayList = new ArrayList<>();
            for (String num : stringArrayList) {
                intArrayList.add(Integer.parseInt(num));
            }
            if (intArrayList.get(1) >= intArrayList.get(2) && intArrayList.get(3) >= intArrayList.get(0)) {
                count2++;
            }
        }
        System.out.println(count2);
    }
}